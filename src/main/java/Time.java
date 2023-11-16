public class Time {

    private int hours, minutes, seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        if (this.hours >= 24) this.hours = 0;
        if (this.minutes >= 60) this.minutes = 0;
        if (this.seconds >= 60) this.seconds = 0;
    }

    public Time() {
        this(0, 0, 0);
    }

    public Time(int hours) {
        this(hours, 0, 0);
    }

    public Time(int hours, int minutes) {
        this(hours, minutes, 0);
    }

    public Time(int seconds, boolean compress) {
        this.seconds = seconds;
        this.hours = 0;
        this.minutes = 0;
        if (compress) this.compress();
    }

    public Time clone() {
        return new Time(this.hours, this.minutes, this.seconds);
    }

    public boolean isEqualTo(Time time) {
        return this.getHours() == time.getHours() && this.getMinutes() == time.getMinutes() && this.getSeconds() == time.getSeconds();
    }

    public void add(Time time) {
        this.hours += time.getHours();
        this.minutes += time.getMinutes();
        this.seconds += time.getSeconds();
        this.compress();
    }

    public void tick() {
        this.seconds++;
        this.compress();
    }

    private void compress() {
        if (this.seconds >= 60) {
            this.minutes += this.seconds / 60;
            this.seconds %= 60;
        }
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes %= 60;
        }
        if (this.hours >= 24) this.hours %= 24;
    }

    public Time differenceTo(Time time) {
        // convert both times to seconds
        int s1 = this.getHours() * 3600 + this.getMinutes() * 60 + this.getSeconds();
        int s2 = time.getHours() * 3600 + time.getMinutes() * 60 + time.getSeconds();

        if (s2 < s1) s2 += 24* 3600;

        int difference = Math.abs(s2 - s1);
        return new Time(difference, true);
    }

    public String toString() {
        return String.format("Time(hours: %d, minutes: %d, seconds: %d)", hours, minutes, seconds);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
