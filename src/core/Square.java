package core;

public class Square { // todo most probably remove...
    private byte position;

    private Square(byte pos){
        this.position = pos;
    }

    public byte getPosition(){
        return position;
    }

    public void print(){
        System.out.print("#"+ Parser.parse(this.position) + " ");
    }

    public static Square[] createAllSquares() {

        Square[] allSquares = new Square[64];
        for (byte b = 0; b <= 63; b++) {
            allSquares[b] = new Square(b);
        }
        return allSquares;
    }
}
