package b.b.a.h;

import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FlexInputEvent.kt */
/* loaded from: classes3.dex */
public abstract class a {

    /* compiled from: FlexInputEvent.kt */
    /* renamed from: b.b.a.h.a$a, reason: collision with other inner class name */
    public static final class C0060a extends a {
        public static final C0060a a = new C0060a();

        public C0060a() {
            super(null);
        }
    }

    /* compiled from: FlexInputEvent.kt */
    public static final class b extends a {
        public static final b a = new b();

        public b() {
            super(null);
        }
    }

    /* compiled from: FlexInputEvent.kt */
    public static final class c extends a {
        public static final c a = new c();

        public c() {
            super(null);
        }
    }

    /* compiled from: FlexInputEvent.kt */
    public static final class d extends a {
        public final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(null);
            m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.a = str;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof d) && m.areEqual(this.a, ((d) obj).a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return b.d.b.a.a.J(b.d.b.a.a.U("ShowToast(text="), this.a, ")");
        }
    }

    /* compiled from: FlexInputEvent.kt */
    public static final class e extends a {
        public final int a;

        public e(@StringRes int i) {
            super(null);
            this.a = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof e) && this.a == ((e) obj).a;
            }
            return true;
        }

        public int hashCode() {
            return this.a;
        }

        public String toString() {
            return b.d.b.a.a.B(b.d.b.a.a.U("ShowToastStringRes(textResId="), this.a, ")");
        }
    }

    public a() {
    }

    public a(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
