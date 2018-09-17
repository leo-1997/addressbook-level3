package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Displays all persons in the address "
            + "book as a list with index numbers. According to the alphabetical order.\n\t" + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> sortAllPersons = new ArrayList<>(allPersons);
        sortAllPersons = sortAllPersons.stream().sorted((f1,f2)->String.CASE_INSENSITIVE_ORDER.compare((f1.getName().fullName),f2.getName().fullName)).collect(Collectors.toList());
        return new CommandResult(getMessageForPersonListShownSummary(sortAllPersons),sortAllPersons);
    }

    @Override
    public boolean isMutating() {
        return false;
    }
}
