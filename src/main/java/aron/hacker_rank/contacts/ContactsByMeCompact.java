package aron.hacker_rank.contacts;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ContactsByMeCompact {

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

    private final Node root = new Node('/');

    // add
    public void add(final String name) {
        if ( name == null ) return;

        Node current = root;
        for ( char c : name.toCharArray() ) {
            if ( current.leafs == null ) {
                Node newNode  = new Node(c);
                current.leafs = new HashMap<>();
                current.leafs.put(c, newNode);
                current = newNode;

                // check leaves to see if it already exists
            } else {
                Node node = current.leafs.get(c);
                if ( node == null ) {
                    node = new Node(c);
                    current.leafs.put(c, node);
                }

                current = node;
            }
        }

        current.isContact = true;
    }

    // getContactsStartingWith
    private void collectLeafIfContact(final Node node, final String contactName, final Map<String, Node> collected) {
        if ( node.isContact ) collected.put(contactName, node);

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

        Node node = root;
        for ( char c : string.toCharArray() ) {
            if ( node == null ) return null;
            else if ( node.leafs == null ) return null;

            node = node.leafs.get(c);
        }

        return node;
    }

    public Node getContact(final String name) {
        Node node = getNode(name);
        return node != null && node.isContact ? node : null;
    }

    public void deleteContact(final String name) {
        if ( name == null ) return;

        // collect all the visited nodes as we travel through the trie until we reach the destination
        final Stack<Node> parentNodes = new Stack<>();

        Node current = root;
        for ( char c : name.toCharArray() ) {
            Node child = current.leafs.get(c);

            if ( child == null ) return; // stop immediately if the next node does not exist

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
                    leafs.remove(c);
                    if ( leafs.size() == 0 ) parentNode.leafs = null;
                }
            }
        }
    }
}
