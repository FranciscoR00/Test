private static class KeySelector3 implements KeySelector<tuple3<integer, long,="" string="">, Tuple2<integer, long="">> {
    private static final long serialVersionUID = 1L;

    @Override
    public Tuple2<integer, long=""> getKey(Tuple3<integer, long,="" string=""> t) {
      return new Tuple2<>(t.f0, t.f1);
    }
  }</integer,></integer,></integer,></tuple3<integer,>
