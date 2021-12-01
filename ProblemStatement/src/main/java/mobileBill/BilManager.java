package mobileBill;

public class BilManager
{
    public static void main(String[] args)
    {
        try
        {
            BasePriceWorker basePriceWorker = new BasePriceWorker();

            Thread thread1 = new Thread(basePriceWorker);

            thread1.start();

            CommonUtil.putProduct("samsung");

            CommonUtil.putProduct("iphone");

            CommonUtil.putProduct("redmi");

            ServiceTax serviceTax = new ServiceTax();

            Thread thread2 = new Thread(serviceTax);

            thread2.start();

            GSTTax gstTax = new GSTTax();

            Thread thread3 = new Thread(gstTax);

            thread3.start();

            TotalPrice totalPrice = new TotalPrice();

            Thread thread4 = new Thread(totalPrice);

            thread4.start();

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

    }
}
