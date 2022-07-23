package aron.hacker_rank.contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactsFirst {
    // static section
    public static class Node {
        private Map<Character, Node> leafs;
        private char c;
        private boolean isContact;

        public Node(char c) {
            this.c = c;
            this.isContact = false;
        }

        public void setIsContact(final boolean isContact) {
            this.isContact = isContact;
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

    public void setVerbose(final boolean verbose) {
        this.verbose = verbose;
    }

    public void setVerboseCollect(boolean verboseCollect) {
        this.verboseCollect = verboseCollect;
    }

    public void add (final String name) {
        if ( name == null ) return;
        if ( verbose ) System.out.println("\nadd() " + name);

        Node curr = root;
        for ( char character : name.toCharArray() ) {
            if ( verbose ) System.out.println("@ " + curr.c);

            if ( curr.leafs == null ) {
                if ( verbose )  System.out.println("+ " + character);

                Node nextNode = new Node(character);
                curr.leafs    = new HashMap<>();
                curr.leafs.put(character, nextNode);
                curr = nextNode;

            } else {
                Node nextNode = curr.leafs.get(character);

                if ( nextNode == null ) {
                    if ( verbose ) System.out.println("+ " + character);
                    nextNode = new Node(character);
                    curr.leafs.put(character, nextNode);
                }

                curr = nextNode;
            }
        }

        curr.isContact = true;
    }

    private Node getNode(final String string) {
        if ( string == null ) return null;

        if ( verbose ) System.out.println("\ngetNode() " + string);

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
            if ( node != null ) System.out.println("@ " + node.c + " isContact " + node.isContact);
        }

        return node;
    }

    private void collectLeafIfContact(final Node node, final String contactName, final Map<String, Node> collected) {
        if ( verboseCollect ) System.out.printf("\ncollectLeafIfContact() (%c) (%s)\n", node.c, contactName);

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

    public Map<String, Node> getContacts(final String startsWith) {
        final Map<String,Node> contacts = new HashMap<>();

        collectLeafIfContact(getNode(startsWith), startsWith, contacts);

        return contacts;
    }

    public Node getContact(final String name) {
        Node node = getNode(name);
        return node != null && node.isContact ? node : null;
    }

    public void deleteContact(final String name) {

    }
}
