package classesInterfaces.multiplicationTable;

public class MultiplicationTable implements TimesTables {
    @Override
    public String showTimesTable(int number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            builder.append(number * i).append(" ");
        }
        return builder.toString();
    }
}
