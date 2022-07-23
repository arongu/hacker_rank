package aron.hacker_rank.contacts;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ContactsFirst {
    // static section
    public static class Node {
        private Map<Character, Node> leafs;
        private final char c;
        private boolean isContact;

        public Node(final char c) {
            this.c = c;
            this.isContact = false;
        }

        public char getC() {
            return c;
        }
    }

    // instance section
    private final Node root;
    private boolean verbose, verboseCollect;

    public ContactsFirst() {
        root           = new Node('/');
        verbose        = false;
        verboseCollect = false;
    }

    // debug
    public void setVerbose(final boolean verbose) {
        this.verbose = verbose;
    }

    public void setVerboseCollect(boolean verboseCollect) {
        this.verboseCollect = verboseCollect;
    }

    // add
    public void add(final String name) {
        if ( name == null ) return;
        if ( verbose ) System.out.printf("\nadd ( %s )\n", name);

        Node current_node = root;
        for ( char letter : name.toCharArray() ) {
            if ( verbose ) System.out.println("@ " + current_node.c);

            if ( current_node.leafs == null ) {
                if ( verbose ) System.out.println("+ " + letter);

                Node new_node_with_letter = new Node(letter);
                current_node.leafs = new HashMap<>();
                current_node.leafs.put(letter, new_node_with_letter);
                current_node = new_node_with_letter;

            } else {
                Node node_with_letter = current_node.leafs.get(letter);

                if ( node_with_letter == null ) {
                    if ( verbose ) System.out.println("+ " + letter);
                    node_with_letter = new Node(letter);
                    current_node.leafs.put(letter, node_with_letter);
                }

                current_node = node_with_letter;
            }
        }

        current_node.isContact = true;
    }

    // getContacts
    private void collectLeafIfContact(final Node node, final String contactName, final Map<String, Node> collected) {
        if ( verboseCollect ) System.out.printf("\ncollectLeafIfContact ( %c, %s )\n", node.c, contactName);

        if ( node.isContact ) {
            if ( verboseCollect ) System.out.println("++ " + contactName);
            collected.put(contactName, node);
        }

        if ( node.leafs != null ) {
            for ( Map.Entry<Character, Node> entry : node.leafs.entrySet() ) {
                Node n = entry.getValue();
                collectLeafIfContact(n, contactName + n.c, collected);
            }
        }
    }

    public Map<String, Node> getContactsStartingWith(final String startsWith) {
        final Map<String,Node> contacts = new HashMap<>();

        collectLeafIfContact(getNode(startsWith), startsWith, contacts);

        return contacts;
    }

    // getContact
    private Node getNode(final String string) {
        if ( string == null ) return null;

        if ( verbose ) System.out.printf("\ngetNode ( %s )\n", string);

        Node node = root;
        for ( char c : string.toCharArray() ) {
            if ( verbose ) System.out.println("@ " + node.c);

            if ( node == null ) {
                return null;

            } else {
                if ( node.leafs == null ) return null;
                node = node.leafs.get(c);
            }
        }

        if ( verbose ) {
            if ( node != null ) System.out.println("@ " + node.c + "\nisContact = " + node.isContact);
        }

        return node;
    }

    public Node getContact(final String name) {
        Node node = getNode(name);
        return node != null && node.isContact ? node : null;
    }

    public void deleteContact(final String name) {
        if ( name == null ) return;
        if ( verbose ) System.out.printf("\ndelete ( %s )\n", name);

        // collect nodes as it traverses through the tree
        final Stack<Map<Character, Node>> parents = new Stack<>();
        Node node = root;

        for ( char c : name.toCharArray() ) {
            Node lookup = node.leafs.get(c);
            if ( lookup == null ) {
                if ( verbose ) System.out.printf("?- %c\n", c);
                return;
            }

            parents.push(node.leafs);
            node = lookup;
        }

        // self test
        if ( parents.size() != name.length() ) {
            System.out.printf("delete ( %s ) -- error length = %d, stack = %d\n", name, name.length(), parents.size());
        }

        // delete nodes
        for ( int i = name.length() - 1; i >= 0; i-- ) {
            Map<Character, Node> parent = parents.pop();
            char c = name.charAt(i);

            if ( parent != null ) {
                Node toBeDeleted = parent.get(c);
                if ( ! (toBeDeleted.leafs != null && toBeDeleted.leafs.size() > 0) ) {
                    parent.remove(c);
                    if ( verbose ) System.out.printf("- %c\n", c);
                } else {
                    if ( verbose ) System.out.printf("!- %c\n", c);
                }

            }
        }
    }
}
