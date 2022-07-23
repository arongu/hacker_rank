package aron.hacker_rank.contacts;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ContactsFirstTest {
    private static final ContactsFirst contacts;

    static {
        contacts = new ContactsFirst();
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
        contacts.add("Dorina");
    }

    @Test
    public void go() {
        contacts.getContacts("Alm");
        Map<String, ContactsFirst.Node> contacts_alm = contacts.getContacts("Alm");
        assertEquals('a', contacts_alm.get("Alma").getC());
        assertEquals('s', contacts_alm.get("Almas").getC());
        assertEquals('k', contacts_alm.get("AlmasSok").getC());
        assertEquals('o', contacts_alm.get("Almo").getC());
        assertEquals(4, contacts_alm.size());

        assertNull(contacts.getContact("Dorx"));
        assertEquals('a', contacts.getContact("Dora").getC());
    }
}

