package aron.hacker_rank.contacts;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ContactsByMe {
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

    public ContactsByMe() {
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

        // collect all the visited nodes as we travel through the trie until we reach the destination
        final Stack<Node> parentNodes = new Stack<>();

        Node current = root;
        for ( char c : name.toCharArray() ) {
            Node child = current.leafs.get(c);

            if ( child == null ) {
                if ( verbose ) System.out.printf("?- %c\n", c);
                return; // stop immediately if the next node does not exist
            }

            parentNodes.push(current);
            current = child;
        }

        // delete nodes
        for ( int i = name.length() - 1; i >= 0; i-- ) {
            Node parentNode = parentNodes.pop();
            Map<Character, Node> leafs = parentNode.leafs;

            char c = name.charAt(i);

            if ( leafs != null ) {
                Node deleteMe = leafs.get(c);
                // only remove the node if it has no other leaves
                if ( deleteMe.leafs == null || deleteMe.leafs.size() == 0 ) {
                    if ( verbose ) System.out.printf("- %c\n", c);
                    leafs.remove(c);

                    // delete the map itself, if it is not being used
                    if ( leafs.size() == 0 ) parentNode.leafs = null;

                } else {
                    if ( verbose ) System.out.printf("!- %c\n", c);
                }
            }
        }
    }
}
