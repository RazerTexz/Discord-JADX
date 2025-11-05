package b.a.d;

/* compiled from: AppState.kt */
/* loaded from: classes.dex */
public final class k<T, R> implements j0.k.b<Integer, Boolean> {
    public static final k j = new k();

    @Override // j0.k.b
    public Boolean call(Integer num) {
        return Boolean.valueOf(num.intValue() > 0);
    }
}
