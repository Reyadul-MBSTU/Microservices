package problemSolving;

public class ExcelSheetColumnTitle {

        public String convertToTitle(int cNum) {
            StringBuilder res = new StringBuilder();
            while(cNum > 0){
                cNum--;

                int letterDistFromA = cNum % 26;

                cNum /= 26;

                res.append((char)('A' + letterDistFromA));
            }
            res.reverse();

            return res.toString();
        }

    public static void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
        int colNumber = 28;
        String ans = excelSheetColumnTitle.convertToTitle(colNumber);
        System.out.println(ans);
    }
}
