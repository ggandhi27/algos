package designpattern.adapter;

interface SamsungCharge {

  Integer charge();
}

interface HuaweiCharge {

  Integer charge();
}

class SamsungCharger implements SamsungCharge {

  private Integer voltage;
  private Integer current;

  public SamsungCharger(Integer voltage, Integer current) {
    this.voltage = voltage;
    this.current = current;
  }

  @Override
  public Integer charge() {
    return this.current * this.voltage;
  }
}

class HuaweiCharger implements HuaweiCharge {

  private Integer voltage;
  private Integer current;

  public HuaweiCharger(Integer voltage, Integer current) {
    this.voltage = voltage;
    this.current = current;
  }

  @Override
  public Integer charge() {
    return this.current * this.voltage + 2;
  }
}

class ChargerAdapter implements SamsungCharge {

  private HuaweiCharge huaweiCharge;

  public ChargerAdapter(HuaweiCharge huaweiCharge) {
    this.huaweiCharge = huaweiCharge;
  }

  @Override
  public Integer charge() {
    return huaweiCharge.charge() - 2;
  }

}

public class Demo {

  public static void main(String[] args) {
    SamsungCharge samsungCharge = new SamsungCharger(1, 15);
    System.out.println(samsungCharge.charge());
    HuaweiCharge huaweiCharge = new HuaweiCharger(2, 9);
    System.out.println(huaweiCharge.charge());
    ChargerAdapter adapter = new ChargerAdapter(huaweiCharge);
    System.out.println(adapter.charge());
  }

}
