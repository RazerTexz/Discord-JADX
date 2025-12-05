package p007b.p195g.p196a.p198b.p199o;

import androidx.recyclerview.widget.RecyclerView;
import java.math.BigDecimal;
import java.math.BigInteger;
import p007b.p195g.p196a.p198b.JsonParser;

/* compiled from: ParserMinimalBase.java */
/* renamed from: b.g.a.b.o.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ParserMinimalBase extends JsonParser {

    /* renamed from: j */
    public static final BigInteger f4532j;

    /* renamed from: k */
    public static final BigInteger f4533k;

    /* renamed from: l */
    public static final BigInteger f4534l;

    /* renamed from: m */
    public static final BigInteger f4535m;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(-2147483648L);
        f4532j = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2147483647L);
        f4533k = bigIntegerValueOf2;
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        f4534l = bigIntegerValueOf3;
        BigInteger bigIntegerValueOf4 = BigInteger.valueOf(RecyclerView.FOREVER_NS);
        f4535m = bigIntegerValueOf4;
        new BigDecimal(bigIntegerValueOf3);
        new BigDecimal(bigIntegerValueOf4);
        new BigDecimal(bigIntegerValueOf);
        new BigDecimal(bigIntegerValueOf2);
    }

    public ParserMinimalBase(int i) {
        super(i);
    }
}
