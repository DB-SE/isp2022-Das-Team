package base;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException() {
            super("This feature is not implemented in this Version you need to update ur Version immediately!");
        }
}
