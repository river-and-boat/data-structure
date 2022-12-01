package single;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedTableTest {
    @Test
    public void should_add_value_to_first_position_in_linked_table() throws Exception {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();

        // when
        linkedTable.addFirst("position 2");
        linkedTable.addFirst("position 1");

        // then
        assertEquals("position 1", linkedTable.get(0));
        assertEquals("position 2", linkedTable.get(1));
    }

    @Test
    public void should_add_value_after_given_position() throws Exception {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 3");
        linkedTable.addFirst("position 2");
        linkedTable.addFirst("position 1");
        int givenIndex = 2;

        // when
        linkedTable.add(givenIndex, "position added 3");

        // then
        assertEquals("position added 3", linkedTable.get(givenIndex + 1));
        assertEquals(4, linkedTable.size());
    }

    @Test
    public void should_throw_exception_if_position_out_of_bounded() {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 3");
        linkedTable.addFirst("position 2");
        linkedTable.addFirst("position 1");
        int givenIndex = 10;

        // when and then
        Exception exception = assertThrows(Exception.class, () -> linkedTable.add(givenIndex, "position added 10"));
        assertEquals("single linked table capacity not enough", exception.getMessage());
    }

    @Test
    public void should_add_node_to_last_position() throws Exception {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 2");
        linkedTable.addFirst("position 1");

        // when
        linkedTable.addLast("position last");

        // then
        assertEquals("position last", linkedTable.get(2));
    }

    @Test
    public void should_get_first_node() throws Exception {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst( "position 0");
        linkedTable.add(0, "position 1");

        // when and then
        assertEquals("position 0", linkedTable.getFirst());
    }

    @Test
    public void should_find_first_node_which_equal_to_given_value() {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 1");
        linkedTable.addFirst( "position 0");

        // when
        String actualValue = linkedTable.findFirst("position 1");

        // then
        assertEquals("position 1",actualValue);
    }

    @Test
    public void should_return_null_if_given_value_not_exist() {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 1");
        linkedTable.addFirst( "position 0");

        // when
        String actualValue = linkedTable.findFirst("not exist");

        // then
        assertNull(actualValue);
    }

    @Test
    public void should_get_given_index_value() throws Exception {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 1");
        linkedTable.addFirst( "position 0");

        // when
        String actualValue = linkedTable.get(0);

        // then
        assertEquals("position 0", actualValue);
    }

    @Test
    public void should_get_last_node() {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 1");
        linkedTable.addFirst( "position 0");

        // when
        String actualValue = linkedTable.getLast();

        // then
        assertEquals("position 1", actualValue);
    }

    @Test
    public void should_remove_first_node() {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 2");
        linkedTable.addFirst("position 1");
        linkedTable.addFirst( "position 0");

        // when
        linkedTable.removeFirst();

        // then
        assertEquals(2, linkedTable.size());
        assertEquals("position 1", linkedTable.getFirst());
    }

    @Test
    public void should_remove_given_index_node() throws Exception {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 2");
        linkedTable.addFirst("position 1");
        linkedTable.addFirst( "position 0");

        // when
        linkedTable.remove(1);

        // then
        assertEquals(2, linkedTable.size());
        assertEquals("position 0", linkedTable.get(0));
        assertEquals("position 2", linkedTable.get(1));
    }

    @Test
    public void should_remove_last_node() throws Exception {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 2");
        linkedTable.addFirst("position 1");
        linkedTable.addFirst( "position 0");

        // when
        linkedTable.removeLast();

        // then
        assertEquals(2, linkedTable.size());
        assertEquals("position 0", linkedTable.get(0));
        assertEquals("position 1", linkedTable.get(1));
    }

    @Test
    public void should_clear_nodes_in_lined_table() {
        // given
        SingleLinkedTable<String> linkedTable = new SingleLinkedTable<>();
        linkedTable.addFirst("position 2");
        linkedTable.addFirst("position 1");
        linkedTable.addFirst( "position 0");

        // when
        linkedTable.clear();

        // then
        assertEquals(0, linkedTable.size());
        assertNull(linkedTable.getFirst());
    }
}