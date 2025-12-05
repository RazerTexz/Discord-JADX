package p007b.p076b.p077a.p083h;

import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: FlexInputEvent.kt */
/* renamed from: b.b.a.h.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class FlexInputEvent {

    /* compiled from: FlexInputEvent.kt */
    /* renamed from: b.b.a.h.a$a */
    public static final class a extends FlexInputEvent {

        /* renamed from: a */
        public static final a f2202a = new a();

        public a() {
            super(null);
        }
    }

    /* compiled from: FlexInputEvent.kt */
    /* renamed from: b.b.a.h.a$b */
    public static final class b extends FlexInputEvent {

        /* renamed from: a */
        public static final b f2203a = new b();

        public b() {
            super(null);
        }
    }

    /* compiled from: FlexInputEvent.kt */
    /* renamed from: b.b.a.h.a$c */
    public static final class c extends FlexInputEvent {

        /* renamed from: a */
        public static final c f2204a = new c();

        public c() {
            super(null);
        }
    }

    /* compiled from: FlexInputEvent.kt */
    /* renamed from: b.b.a.h.a$d */
    public static final class d extends FlexInputEvent {

        /* renamed from: a */
        public final String f2205a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.f2205a = str;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof d) && Intrinsics3.areEqual(this.f2205a, ((d) obj).f2205a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.f2205a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.m822J(outline.m833U("ShowToast(text="), this.f2205a, ")");
        }
    }

    /* compiled from: FlexInputEvent.kt */
    /* renamed from: b.b.a.h.a$e */
    public static final class e extends FlexInputEvent {

        /* renamed from: a */
        public final int f2206a;

        public e(@StringRes int i) {
            super(null);
            this.f2206a = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof e) && this.f2206a == ((e) obj).f2206a;
            }
            return true;
        }

        public int hashCode() {
            return this.f2206a;
        }

        public String toString() {
            return outline.m814B(outline.m833U("ShowToastStringRes(textResId="), this.f2206a, ")");
        }
    }

    public FlexInputEvent() {
    }

    public FlexInputEvent(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
