package p007b.p109f.p161j.p170e;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p161j.p172g.NoOpCloseableReferenceLeakTracker;

/* compiled from: CloseableReferenceFactory.java */
/* renamed from: b.f.j.e.a, reason: use source file name */
/* loaded from: classes.dex */
public class CloseableReferenceFactory {

    /* renamed from: a */
    public final CloseableReference.InterfaceC10637c f3725a;

    /* compiled from: CloseableReferenceFactory.java */
    /* renamed from: b.f.j.e.a$a */
    public class a implements CloseableReference.InterfaceC10637c {

        /* renamed from: a */
        public final /* synthetic */ NoOpCloseableReferenceLeakTracker f3726a;

        public a(CloseableReferenceFactory closeableReferenceFactory, NoOpCloseableReferenceLeakTracker noOpCloseableReferenceLeakTracker) {
            this.f3726a = noOpCloseableReferenceLeakTracker;
        }

        @Override // com.facebook.common.references.CloseableReference.InterfaceC10637c
        /* renamed from: a */
        public void mo1252a(SharedReference<Object> sharedReference, Throwable th) {
            String string;
            Objects.requireNonNull(this.f3726a);
            Object objM8646c = sharedReference.m8646c();
            String name = objM8646c != null ? objM8646c.getClass().getName() : "<value is null>";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
            objArr[2] = name;
            if (th == null) {
                string = "";
            } else {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                string = stringWriter.toString();
            }
            objArr[3] = string;
            FLog.m987o("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", objArr);
        }

        @Override // com.facebook.common.references.CloseableReference.InterfaceC10637c
        /* renamed from: b */
        public boolean mo1253b() {
            Objects.requireNonNull(this.f3726a);
            return false;
        }
    }

    public CloseableReferenceFactory(NoOpCloseableReferenceLeakTracker noOpCloseableReferenceLeakTracker) {
        this.f3725a = new a(this, noOpCloseableReferenceLeakTracker);
    }
}
