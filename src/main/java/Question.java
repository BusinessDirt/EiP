public record Question(String text, int points) {
    @Override
    public String toString() {
        return String.format("%s:%s", points(), text());
    }
}
