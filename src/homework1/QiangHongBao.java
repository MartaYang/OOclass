package homework1;

import java.util.Random;
import java.util.Scanner;

public class QiangHongBao //�����
{

	public static int[] FenHongBao(int m,int len)
	{
		int[] RandNum = new int[len];
		int tot=0,sum=0;
		for(int i=0;i<len;i++)  //�Ȳ���len���������ͳ��������ĺ�
		{
			Random random = new Random();
			RandNum[i] = random.nextInt(500); 
			tot+=RandNum[i];
		}
		for(int i=0;i<len-1;i++)  //������ݱ�����������������Ϊ��ƽ
		{
			double tem = (double)RandNum[i]/tot*m; //����
			RandNum[i] = (int) Math.floor(tem); //��ȡ������ֹ����
			sum+=RandNum[i];  //ͳ�������ѷ����Ǯ��
		}
		RandNum[len-1] = m-sum; //Ϊ�˷�ֹ�ܺͲ��ԣ����һ�������Ϊʣ�µı���
		return RandNum;
	}
	
	public static void main(String[] args)  throws Exception
	{
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		System.out.print("���������ܽ�");
		int sum=cin.nextInt();
		System.out.print("���������ܸ�����");
		int n=cin.nextInt();
		
		int[] HongBao = FenHongBao(sum*100,n);  //���ú������ֺ�������غ������
		for(int i=0;i<n;i++)
			System.out.println("��"+(i+1)+"�����Ϊ"+HongBao[i]/100+"."+HongBao[i]%100+"Ԫ");
	}

}
