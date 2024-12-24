package strategies;

public class NoMoveMovingStrategy implements IMovingStrategy{
    @Override
    public int move(int destinationPosition) {
        return destinationPosition;
    }
}
