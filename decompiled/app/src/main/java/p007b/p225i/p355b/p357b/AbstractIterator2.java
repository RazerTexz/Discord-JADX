package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p085c.p086a.p095y.C1563b;

/* compiled from: AbstractIterator.java */
/* renamed from: b.i.b.b.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractIterator2<T> extends UnmodifiableIterator<T> {

    /* renamed from: j */
    public int f11970j = 2;

    /* renamed from: k */
    @NullableDecl
    public T f11971k;

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        T t;
        int i = this.f11970j;
        if (!(i != 4)) {
            throw new IllegalStateException();
        }
        int iM758h = C1563b.m758h(i);
        if (iM758h == 0) {
            return true;
        }
        if (iM758h == 2) {
            return false;
        }
        this.f11970j = 4;
        Sets2 sets2 = (Sets2) this;
        while (true) {
            if (!sets2.f12043l.hasNext()) {
                sets2.f11970j = 3;
                t = null;
                break;
            }
            t = (T) sets2.f12043l.next();
            if (sets2.f12044m.f12011k.contains(t)) {
                break;
            }
        }
        this.f11971k = t;
        if (this.f11970j == 3) {
            return false;
        }
        this.f11970j = 1;
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f11970j = 2;
        T t = this.f11971k;
        this.f11971k = null;
        return t;
    }
}
