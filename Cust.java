import java.util.Scanner;
import static java.lang.System.exit;

public class Cust {
    public int money;  //金额
    public int count;  //余额
    public String time;  //时间
    public String remark; //备注
    public String sort;   //类别
    public int months;   //月份

    public static int[] income_month = new int[12];  //每个月份的收入
    public static int[] output_month = new int[12];

    public Cust(){

    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public static void menu(){
        System.out.println("=====================");
        System.out.println("欢迎使用个人账单管理系统");
        System.out.println("=====================");
        System.out.println("请选择操作：");
        System.out.println("1.记录收入");
        System.out.println("2.记录支出");
        System.out.println("3. 查看所有账单");
        System.out.println("4. 查询账单");
        System.out.println("5. 设置月度预算");
        System.out.println("6. 查看月度统计报告");
        System.out.println("7. 退出系统");
        /*3. 查看所有账单（第三周任务添加）
          4. 查询账单（第三周任务添加）
          5. 设置月度预算（第五周任务添加）
          6. 查看月度统计报告（第五周任务添加）
          7. 退出系统*/
    }

    // 记录收入信息
    public void record_Get(Scanner sc, Cust[] arr, int index) {
        System.out.println("请输入收入信息：");
        System.out.print("日期（YYYY-MM-DD）：");
        arr[index].time = sc.next();
        arr[index].months = Integer.parseInt(arr[index].time.substring(5, 7)) - 1;
        System.out.print("金额：");
        while (true) {
            arr[index].money = sc.nextInt();
            if (arr[index].money >= 0) {
                income_month[months] += arr[index].money ;
                break;
            } else {
                System.out.println("金额错误！");
            }
        }
        System.out.print("类别（如工资、奖金等）：");
        arr[index].sort = sc.next();
        System.out.print("备注：");
        arr[index].remark = sc.next();
        System.out.println("收入已成功记录！");
    }

    // 记录支出信息
    public void record_output(Scanner sc, Cust[] arr, int index) {
        System.out.println("请输入支出信息：");
        System.out.print("日期（YYYY-MM-DD）：");
        arr[index].time = sc.next();
        arr[index].months = Integer.parseInt(arr[index].time.substring(5, 7)) - 1;
        System.out.print("金额：");
        while (true) {
            arr[index].money = sc.nextInt();
            if (arr[index].money >= 0) {
                output_month[months] += arr[index].money ;
                break;
            } else {
                System.out.println("金额错误！");
            }
        }
        System.out.print("类别（如餐饮、交通、购物等）：");
        arr[index].sort = sc.next();
        System.out.print("备注：");
        arr[index].remark = sc.next();
        System.out.println("支出已成功记录！");
    }


    // 打印所有记录
    public void print(Cust[] arr, int count) {
        System.out.println("日期（YYYY-MM-DD）："+ time);
        System.out.println("金额："+ money);
        System.out.println("类别："+ sort);
        System.out.println("备注："+ remark);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cust[] array = new Cust[100];   //收入
        Cust[] array1 = new Cust[100];  //支出
        int[] budget = new int[12];
        int i = 0;
        int j = 0;

        while (true) {
            menu();
            int choice;
            System.out.println("请输入选项序号：");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    array[i] = new Cust();
                    array[i].record_Get(sc, array,i);
                    i++;
                    break;

                case 2:
                    array1[j] = new Cust();
                    array1[j].record_output(sc,array1,j);
                    j++;
                    break;

                case 3:
                    if (i == 0 && j == 0) {
                        System.out.println("没有记录可显示。");
                    } else {
                        System.out.println("收入记录");
                        for (int k = 0; k < i; k++) {
                            array[k].print(array, i);
                        }
                        System.out.println("支出记录：");
                        for (int k = 0; k < j; k++) {
                            array1[k].print(array1, j);
                        }
                    }
                    break;

                case 4:
                    //账单查询：用户可以按照指定日期、日期范围或类别查询账单，收入和支出分开显示。
                    System.out.print("请输入日期（YYYY-MM-DD）：");
                    String date = sc.next();
                    for (int k = 0; k < i; k++) {
                        if(date.equals(array[k].time)){
                            array[k].print(array, i);
                        }
                    }
                    for (int k = 0; k < j; k++) {
                        if(date.equals(array1[k].time)){
                            array1[k].print(array1, j);
                        }
                    }
                    break;
                    //月度预算
                    //5.预算管理:用户可以设置每个月支出的预算限额，系统显示当前剩余可用预算。
                    //6.月度统计:系统可以统计每月的总收入、总支出和各类别的金额。
                case 5:
                    System.out.print("请输入月份：");
                    int months = sc.nextInt();
                    System.out.print("请输入这个月的支出限额：");
                    budget[months-1] = sc.nextInt();
                    for (int k = 0; k < j; k++) {
                        if(array1[k].months+1 == months) {
                            budget[months-1] -= array1[k].money;
                        }
                    }
                    System.out.println("本月剩余可用预算：" + budget[months-1]);
                    break;

                    //月度统计
                case 6:
                    for (int z = 1; z <= 12; z++) {
                        System.out.println("第" + z + "月的总收入：" + income_month[z-1]);
                        System.out.println("第" + z + "月的总支出：" + output_month[z-1]);
                    }
                    break;

                case 7:
                    exit(0);
            }
        }
    }
}




