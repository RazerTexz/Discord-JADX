package p659s.p660a.p661a;

import p507d0.Result2;
import p507d0.Result3;

/* JADX INFO: renamed from: s.a.a.s, reason: use source file name */
/* JADX INFO: compiled from: StackTraceRecovery.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StackTraceRecovery {

    /* JADX INFO: renamed from: a */
    public static final String f27703a;

    /* JADX INFO: renamed from: b */
    public static final String f27704b;

    static {
        Object objM11474constructorimpl;
        Object objM11474constructorimpl2;
        try {
            Result2.a aVar = Result2.f25169j;
            objM11474constructorimpl = Result2.m11474constructorimpl(Class.forName("d0.w.i.a.a").getCanonicalName());
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.f25169j;
            objM11474constructorimpl = Result2.m11474constructorimpl(Result3.createFailure(th));
        }
        if (Result2.m11476exceptionOrNullimpl(objM11474constructorimpl) != null) {
            objM11474constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f27703a = (String) objM11474constructorimpl;
        try {
            Result2.a aVar3 = Result2.f25169j;
            objM11474constructorimpl2 = Result2.m11474constructorimpl(Class.forName("s.a.a.s").getCanonicalName());
        } catch (Throwable th2) {
            Result2.a aVar4 = Result2.f25169j;
            objM11474constructorimpl2 = Result2.m11474constructorimpl(Result3.createFailure(th2));
        }
        if (Result2.m11476exceptionOrNullimpl(objM11474constructorimpl2) != null) {
            objM11474constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f27704b = (String) objM11474constructorimpl2;
    }
}
