package strategies;

public class MovingToTailMovingStrategy implements IMovingStrategy{
    @Override
    public int move(int destinationPosition) {
        return destinationPosition;
    }
}
