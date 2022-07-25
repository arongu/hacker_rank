package aron.hacker_rank.contacts;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ContactsByMeTest {
    private static final ContactsByMe contacts;

    static {
        contacts = new ContactsByMe();
        contacts.setVerbose(true);

        contacts.add("Alma");
        contacts.add("Almas");
        contacts.add("AlmasSok");
        contacts.add("Almo");
        //
        contacts.add("Alon");
        contacts.add("Bea");
        contacts.add("Beatrix");
        contacts.add("Beabeast");
        contacts.add("Cec");
        contacts.add("Cecil");
        contacts.add("Dorka");
        contacts.add("Dora");
        contacts.add("Dorb");
        contacts.add("Dorina");
    }

    @Test
    public void go() {
        Map<String, ContactsByMe.Node> contacts_alm = contacts.getContactsStartingWith("Alm");
        assertEquals('a', contacts_alm.get("Alma").getC());
        assertEquals('s', contacts_alm.get("Almas").getC());
        assertEquals('k', contacts_alm.get("AlmasSok").getC());
        assertEquals('o', contacts_alm.get("Almo").getC());
        assertEquals(4, contacts_alm.size());

        assertNull(contacts.getContact("Dorx"));
        assertEquals('a', contacts.getContact("Dora").getC());
    }

    @Test
    public void delete() {
        /*
        contacts.add("Dorka");
        contacts.add("Dora");
        contacts.add("Dorb");
        contacts.add("Dorina"); <-
         */
        contacts.deleteContact("Dorina");

        Map<String, ContactsByMe.Node> contacts_dor = contacts.getContactsStartingWith("Dor");
        assertFalse(contacts_dor.containsKey("Dorina"));
        assertTrue(contacts_dor.containsKey("Dorka"));
        assertTrue(contacts_dor.containsKey("Dora"));
        assertTrue(contacts_dor.containsKey("Dorb"));

        contacts.deleteContact("Dksaldkasldkasl");
        contacts.add("Dorina");
        assertEquals('a', contacts.getContact("Dorina").getC());
        contacts.deleteContact("D");
    }

    @Test
    public void delete2() {
        final ContactsByMe contacts = new ContactsByMe();
        contacts.setVerbose(true);
        contacts.deleteContact("alma");
    }
}

