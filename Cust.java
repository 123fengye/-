package Cust;

import java.util.Scanner;
public class Cust {
    public int money;//余额
    public int count;
    public String time;
    public String remark;
    public String sort;

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
        System.out.print("金额：");
        while (true) {
            arr[index].money = sc.nextInt();
            if (arr[index].money >= 0) {
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
        System.out.print("金额：");
        while (true) {
            arr[index].money = sc.nextInt();
            if (arr[index].money >= 0) {
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
        Cust[] array = new Cust[100];
        int i = 0;


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
                    array[i] = new Cust();
                    array[i].record_output(sc,array,i);
                    i++;
                    break;

                case 3:
                    if (i == 0) {
                        System.out.println("没有记录可显示。");
                    } else {
                        for (int j = 0; j < i; j++) {
                            array[j].print(array, i);
                        }
                    }
                    break;

                case 4:
                    System.out.print("请输入日期（YYYY-MM-DD）：");
                    String date = sc.next();
                    for (int j = 0; j < i; j++) {
                        if(date.equals(array[j].time)){
                            array[j].print(array, i);
                        }
                    }    
	    }
        }
    }
}


