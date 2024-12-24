package strategies;

public class MoveToStartMovingStrategy implements IMovingStrategy{
    @Override
    public int move(int destinationPosition) {
        return destinationPosition;
    }
}
