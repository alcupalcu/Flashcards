// Posted from EduTools plugin
class Employee {

    protected String name;
    protected String email;
    protected int experience;

    protected Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience= experience;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getExperience() {
        return this.experience;
    }
}

class Developer extends Employee {

    protected String mainLanguage;
    protected String[] skills;

    protected Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = new String[skills.length];
        for(int i = 0; i < skills.length; i++) {
            this.skills[i] = skills[i];
        }
    }

    public String getMainLanguage() {
        return this.mainLanguage;
    }

    public String[] getSkills() {
        return this.skills;
    }
}

class DataAnalyst extends Employee {

    protected boolean phd;
    protected String[] methods;

    protected DataAnalyst(String name, String email, int experience, boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = new String[methods.length];
        for(int i = 0; i < methods.length; i++) {
            this.methods[i] = methods[i];
        }
    }

    public boolean isPhd() {
        return this.phd;
    }

    public String[] getMethods() {
        return this.methods;
    }
}