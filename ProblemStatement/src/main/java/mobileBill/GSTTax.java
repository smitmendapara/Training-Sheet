package mobileBill;

public class GSTTax implements Runnable
{
    int tax = 18;

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                int GSTPrice = CommonUtil.takeGSTPrice();

                if (GSTPrice >= 0)
                {
                    int GSTvalue = ( (GSTPrice / 100) * tax ) + GSTPrice;

                    CommonUtil.putTotalPrice(GSTvalue);
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
