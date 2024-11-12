import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
class Tests {
    private List<BankAccount> accounts;
    @BeforeEach
    void setUp() {
        accounts = List.of(
                new BankAccount(new Person("Дарья", "Волошина", "voloshina1112@mail.com"), "DE10000001", 10500),
                new BankAccount(new Person("Диана", "Смирнова", "smirnova1@mail.com"), "DE10000002", 500),
                new BankAccount(new Person("Никита", "Юсупов", "yusupow32@mail.com"), "DE10000002", 92.10),
                new BankAccount(new Person("Света", "Иванова", "ivanova543@mail.com"), "DE10000003", 1000),
                new BankAccount(new Person("Раиса", "Синицина", "sinitsina111@mail.com"), "DE10000004", 81.90)
        );
    }
    @Test
    @DisplayName("Аккаунты меньше 100")
    void test_Accounts_Menshe100() {
        List<BankAccount> expectedResult = List.of(
                new BankAccount(new Person("Никита", "Юсупов", "yusupow32@mail.com"), "DE10000002", 92.10),
                new BankAccount(new Person("Раиса", "Синицина", "sinitsina111@mail.com"), "DE10000004", 81.90)
        );
        List<BankAccount> actualResult = Main.getAccountsLessThen(accounts, 100);
        Assertions.assertIterableEquals(new HashSet<>(expectedResult),new HashSet<>(actualResult));
    }
    //////////////////////////////////////////////////
    //////////до этого момента все проверила. осталось пересмотреть непонятные тесты
    @Test
    @DisplayName("Аккаунты меньше 50 - нет")
    void test_Account_NetMenshe50 () {
        List<BankAccount> actualResult = Main.getAccountsLessThen(accounts, 50);
        Assertions.assertTrue(actualResult.isEmpty());
    }
    @Test
    @DisplayName("Если Лист null")
    void test_Accounts_ListNull () {
        List<BankAccount> actualResult = Main.getAccountsLessThen(null, 50);
        Assertions.assertTrue(actualResult.isEmpty());
    }
    @Test
    @DisplayName("Добавить всех клиентов в список")
    void getAllClients_regularCase() {
        List<Person> expectedResult = List.of(
                new Person("Дарья", "Волошина", "voloshina1112@mail.com"),
                new Person("Диана", "Смирнова", "smirnova1@mail.com"),
                new Person("Никита", "Юсупов", "yusupow32@mail.com"),
                new Person("Света", "Иванова", "ivanova543@mail.com"),
                new Person("Раиса", "Синицина", "sinitsina111@mail.com")
        );
        List<Person> actualResult = Main.getAllClients(accounts);
        Assertions.assertIterableEquals(expectedResult,actualResult, "#345: метод getAllClients не сработал");
    }
    @Test
    @DisplayName("Добавить всех клиентов если bankAccounts = null")
    void test_Accounts_EsliListNull () {
        List<Person> actualResult = Main.getAllClients(null);
        Assertions.assertTrue(actualResult.isEmpty());
    }
    @Test
    @DisplayName("Лист с инициалом имени, баланс которых более 999")
    void test_Accounts_bolshe() {
        List<String> expectedResult = List.of(
                "Волошина Д.; DE10000001;voloshina1112@mail.com",
                "Иванова С.; DE10000003;ivanova543@mail.com"
        );
        List<String> actualResult = Main.getRichClientsReport(accounts, 999);
        Assertions.assertIterableEquals(expectedResult,actualResult);
    }
}

