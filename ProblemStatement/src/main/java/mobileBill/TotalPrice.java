package mobileBill;

public class TotalPrice implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                int lastPrice = CommonUtil.takeTotalPrice();

                System.out.println(lastPrice);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
