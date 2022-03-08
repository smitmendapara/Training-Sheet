package mobileBill;

public class ServiceTax implements Runnable
{
    int tax = 10;

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                int price = CommonUtil.takeServiceTaxPrice();

                if (price >= 0)
                {
                    int serviceTax = ( (price / 100) * tax ) + price;

                    CommonUtil.putGSTPrice(serviceTax);
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
