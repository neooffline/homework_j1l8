package ru.neooffline.homework_j1l8;
import java.util.Random;



public class Persona {
    /** Класс с данными от сотруднике
     * @param name - Имя
     * @param secondName - Фамилия
     * @param fullName - Ф.И.
     * @param email - почта
     * @param profession - должность
     * @param mobileNumber - номер мобильного телефона
     * @param age - возраст
     * @param workCost - ЗП
     * @param personaCount - порядковый номер созданного человека.
     * */

    private Random random = new Random();
    private String name;
    private String secondName;
    private String profession;
    private String fullName;
    private String email;
    private long mobileNumber;
    protected int MIN_AGE = 18;
    protected int MAX_AGE = 80;
    private int age;
    protected int MIN_WORK_COST = 15000;
    protected int MAX_WORK_COST = 250000;
    private int workCost;
    private static int count = 0;
    private int personaCount;


    public int getWorkCost() {
        return workCost;
    }

    public void setWorkCost(int workCost) {
        this.workCost = workCost;
    }

    public int getPersonaCount() {
        return personaCount;
    }

    void splitFullName(){
        fullName = name + " " + secondName;
    }

    public String getFullName() { return fullName; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String login, String domen) {
        this.email = login + "@" + domen ;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean chechEmail(String emale){ //Проверка корректности e-mail если будет нужно

        return emale.contains(".")&&emale.contains("@");
    }

    public boolean checkNumber(long mobileNumber){ //Проверка корректности номера если будет нужно
        return Long.toString(mobileNumber).length()==11;
    }

    Persona(String name, String family, String profession, String login, String domen, long number, int workCost, int age){
        count++;
        setName(name);
        setSecondName(family);
        splitFullName();
        setEmail(login,domen);
        setMobileNumber(number);
        setProfession(profession);
        setWorkCost(workCost);
        setAge(age);
        personaCount = count;
    }

    /**
     * Конструктор для инициализцации массива элементов сотрудников с случайными данными
     * @param names - Массив имен
     * @param families - массив фамилий
     * @param professions - массив профессий
     * @param logins - массив логинов почты
     * @param domens - массив домена поты
     * @param number - номер телефона, можно тоже генерировавать но не стал
     */
    Persona(String[] names, String[] families, String[] professions, String[] logins, String[] domens, long[] number){
        count ++;
        setName(names[random.nextInt(names.length)]);
        setSecondName(families[random.nextInt(families.length)]);
        splitFullName();
        setEmail(logins[random.nextInt(logins.length)],domens[random.nextInt(domens.length)]);
        setMobileNumber(number[random.nextInt(number.length)]);
        setProfession(professions[random.nextInt(professions.length)]);
        setAge(random.nextInt(MAX_AGE - MIN_AGE) + MIN_AGE);
        setWorkCost(random.nextInt(MAX_WORK_COST- MIN_WORK_COST) + MIN_WORK_COST);
        personaCount = count;
    }
    Persona(Persons persons){
        count ++;
        setName(persons.names[random.nextInt(persons.names.length)]);
        setSecondName(persons.families[random.nextInt(persons.families.length)]);
        splitFullName();
        setEmail(persons.logins[random.nextInt(persons.logins.length)],
                persons.domens[random.nextInt(persons.domens.length)]);
        setMobileNumber(persons.number[random.nextInt(persons.number.length)]);
        setProfession(persons.professions[random.nextInt(persons.professions.length)]);
        setAge(random.nextInt(MAX_AGE - MIN_AGE) + MIN_AGE);
        setWorkCost(random.nextInt(MAX_WORK_COST- MIN_WORK_COST) + MIN_WORK_COST);
        personaCount = count;
    }
    /**
     * Конструктор с тестовыми данными
     */
    Persona(){
        count++;
        setName("Тест");
        setSecondName("Тестов");
        splitFullName();
        setEmail("user","ya.ru");
        setMobileNumber(89262664528L);
        setProfession("инженер");
        setAge(22);
        setWorkCost(23000);
        personaCount = count;
    }

    /**
     * @param persona Печать всех данных о сотруднике в одну строку
     */
    static void printData(Persona persona) {
        System.out.printf("№: %d - %s; Должность: %s; Телефон: %d; e-mail: %s; Зарплата: %d руб.; Возраст: %d.",
                persona.personaCount, persona.getFullName(), persona.getProfession(), persona.getMobileNumber(),
                persona.getEmail(), persona.getWorkCost(), persona.getAge());
        System.out.println();
    }
    String dataToString(Persona persona){
        return (persona.getFullName() + " ") +
                persona.getProfession() + " " +
                persona.getMobileNumber() + " " +
                persona.getEmail() + " " +
                persona.getWorkCost() + " " +
                persona.getAge() + " " +
                "\n";
    }
}
