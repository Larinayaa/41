import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }
    public static List<BankAccount> getAccountsLessThen(List<BankAccount> bankAccounts, double limit) {
        if (bankAccounts==null || bankAccounts.isEmpty()){
            return Collections.emptyList();
        }
        return bankAccounts.stream()
                .filter(ba-> ba.getBalance()<limit )
                .toList();
    }
    public static List<Person> getAllClients(List<BankAccount> bankAccounts){
        if (bankAccounts==null || bankAccounts.isEmpty()){
            return Collections.emptyList();
        }
        return bankAccounts.stream().map(BankAccount::getOwner).toList();
    }
    public static List<String> getRichClientsReport(List<BankAccount> bankAccounts, double limit){
        if (bankAccounts==null || bankAccounts.isEmpty()){
            return Collections.emptyList();
        }
        Function<BankAccount, String> getAccStrinFunction = ba -> {
            StringBuilder sb = new StringBuilder();
            Person owner = ba.getOwner();
            sb.append(owner.getlName()) //фамилия полностью
                    .append(' ')
                    .append(owner.getfName().charAt(0)) //нулевая ячейка имени
                    .append(".; ")
                    .append(ba.getIBAN())
                    .append(';')
                    .append(owner.getEmail());
            return sb.toString();
        };
        return bankAccounts.stream()
                .filter(ba->ba!=null)
                .filter(ba->ba.getBalance()>limit) //баланс больше лимита
                .map(getAccStrinFunction)
                .toList();
    }



}
