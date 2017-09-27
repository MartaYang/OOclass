package homework1;

import java.util.Random;
import java.util.Scanner;

public class QiangHongBao //抢红包
{

	public static int[] FenHongBao(int m,int len)
	{
		int[] RandNum = new int[len];
		int tot=0,sum=0;
		for(int i=0;i<len;i++)  //先产生len个随机数，统计随机数的和
		{
			Random random = new Random();
			RandNum[i] = random.nextInt(500); 
			tot+=RandNum[i];
		}
		for(int i=0;i<len-1;i++)  //尔后根据比例分配红包，这样最为公平
		{
			double tem = (double)RandNum[i]/tot*m; //比例
			RandNum[i] = (int) Math.floor(tem); //下取整，防止超量
			sum+=RandNum[i];  //统计真正已分配的钱数
		}
		RandNum[len-1] = m-sum; //为了防止总和不对，最后一个红包即为剩下的比例
		return RandNum;
	}
	
	public static void main(String[] args)  throws Exception
	{
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		System.out.print("请输入红包总金额：");
		int sum=cin.nextInt();
		System.out.print("请输入红包总个数：");
		int n=cin.nextInt();
		
		int[] HongBao = FenHongBao(sum*100,n);  //调用函数：分红包，返回红包数组
		for(int i=0;i<n;i++)
			System.out.println("第"+(i+1)+"个红包为"+HongBao[i]/100+"."+HongBao[i]%100+"元");
	}

}
