// Posted from EduTools plugin
class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublishing() {
        return this.yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String[] getAuthors() {
        return this.authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = new String[authors.length];
        for(int i = 0; i < this.authors.length; i++) {
            this.authors[i] = authors[i];
        }
    }
}