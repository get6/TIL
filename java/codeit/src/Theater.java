public class Theater {
    private Seat[][] seats;

    private int rowCount, colCount;

    public Theater(int rowCount, int colCount) {
        if (rowCount > 26) {
            rowCount = 26; // number of alphabets
        }
        seats = new Seat[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                seats[i][j] = new Seat();
            }
        }

        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    /**
     * 예약 정보를 받아 예약한다.
     *
     * @param name    이름
     * @param rowChar 행
     * @param col     열
     * @param numSeat 예약 좌석 수
     * @return
     */
    public boolean reserve(String name, char rowChar, int col, int numSeat) {
        // 여기에 코드를 작성하세요
        int rowIndex = this.getRowIndex(rowChar);
        if (rowIndex >= this.rowCount - 1 || col >= this.colCount) {
            return false;
        } else if (this.colCount < col + numSeat - 1) {
            return false;
        }

        Seat[] rowSeats = this.seats[rowIndex];
        int start = col - 1;
        int end = col - 1 + numSeat;
        for (int i = start; i < end; i++) {
            Seat seat = rowSeats[i];
            if (seat.isOccupied()) {
                return false;
            }
        }

        for (int i = start; i < end; i++) {
            Seat seat = rowSeats[i];
            seat.reserve(name);
        }
        return true;
    }

    public int cancel(String name) {
        // 여기에 코드를 작성하세요
        int cnt = 0;
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.colCount; j++) {
                Seat seat = this.seats[i][j];
                if (seat.isOccupied() && seat.match(name)) {
                    seat.cancel();
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 모든 좌석의 예약을 취소
     *
     * @param rowChar 행
     * @param col     열
     * @param numSeat 좌석 수
     * @return
     */
    public int cancel(char rowChar, int col, int numSeat) {
        // 여기에 코드를 작성하세요
        int row = getRowIndex(rowChar) + 1;
        if (row > rowCount || col > colCount) {
            return 0;
        }

        int cnt = 0;

        Seat[] rowSeats = this.seats[row - 1];
        for (int i = col - 1; i < col + numSeat; i++) {
            Seat seat = rowSeats[i];
            if (seat.isOccupied()) {
                seat.cancel();
                cnt++;
            }
        }

        return cnt;
    }


    public int getNumberOfReservedSeat() {
        int cnt = 0;
        for (Seat[] rows : this.seats) {
            for (Seat col : rows) {
                if (col.isOccupied()) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void printSeatMatrix() {
        System.out.print("  ");
        for (int i = 1; i <= 9; i++) {
            System.out.print("  " + i);
        }
        System.out.println();

        for (int i = 0; i < rowCount; i++) {
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                if (s.isOccupied()) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    private int getRowIndex(char uppercaseChar) {
        return uppercaseChar - 'A';
    }
}