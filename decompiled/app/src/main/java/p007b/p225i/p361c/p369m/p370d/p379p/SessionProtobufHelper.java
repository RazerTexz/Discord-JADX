package p007b.p225i.p361c.p369m.p370d.p379p;

import android.app.ActivityManager;
import java.util.List;
import java.util.Map;
import p007b.p225i.p361c.p369m.p370d.p387t.TrimmedThrowableData;

/* JADX INFO: renamed from: b.i.c.m.d.p.d, reason: use source file name */
/* JADX INFO: compiled from: SessionProtobufHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class SessionProtobufHelper {

    /* JADX INFO: renamed from: a */
    public static final ByteString2 f12694a = ByteString2.m6637a("0");

    /* JADX INFO: renamed from: b */
    public static final ByteString2 f12695b = ByteString2.m6637a("Unity");

    /* JADX INFO: renamed from: a */
    public static int m6657a(ByteString2 byteString2, ByteString2 byteString22) {
        int iM6640b = CodedOutputStream2.m6640b(3, byteString2) + CodedOutputStream2.m6645h(2, 0L) + CodedOutputStream2.m6645h(1, 0L) + 0;
        return byteString22 != null ? iM6640b + CodedOutputStream2.m6640b(4, byteString22) : iM6640b;
    }

    /* JADX INFO: renamed from: b */
    public static int m6658b(String str, String str2) {
        int iM6640b = CodedOutputStream2.m6640b(1, ByteString2.m6637a(str));
        if (str2 == null) {
            str2 = "";
        }
        return CodedOutputStream2.m6640b(2, ByteString2.m6637a(str2)) + iM6640b;
    }

    /* JADX INFO: renamed from: c */
    public static int m6659c(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        int i3 = 0;
        int iM6640b = CodedOutputStream2.m6640b(1, ByteString2.m6637a(trimmedThrowableData.f12778b)) + 0;
        String str = trimmedThrowableData.f12777a;
        if (str != null) {
            iM6640b += CodedOutputStream2.m6640b(3, ByteString2.m6637a(str));
        }
        for (StackTraceElement stackTraceElement : trimmedThrowableData.f12779c) {
            int iM6664h = m6664h(stackTraceElement, true);
            iM6640b += CodedOutputStream2.m6642d(iM6664h) + CodedOutputStream2.m6643e(4) + iM6664h;
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f12780d;
        if (trimmedThrowableData2 == null) {
            return iM6640b;
        }
        if (i < i2) {
            int iM6659c = m6659c(trimmedThrowableData2, i + 1, i2);
            return iM6640b + CodedOutputStream2.m6642d(iM6659c) + CodedOutputStream2.m6643e(6) + iM6659c;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.f12780d;
            i3++;
        }
        return iM6640b + CodedOutputStream2.m6644f(7, i3);
    }

    /* JADX INFO: renamed from: d */
    public static int m6660d() {
        ByteString2 byteString2 = f12694a;
        return CodedOutputStream2.m6645h(3, 0L) + CodedOutputStream2.m6640b(2, byteString2) + CodedOutputStream2.m6640b(1, byteString2) + 0;
    }

    /* JADX INFO: renamed from: e */
    public static int m6661e(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString2 byteString2, ByteString2 byteString22) {
        int iM6643e = CodedOutputStream2.m6643e(1);
        int iM6665i = m6665i(thread, stackTraceElementArr, 4, true);
        int iM6642d = CodedOutputStream2.m6642d(iM6665i) + iM6643e + iM6665i + 0;
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int iM6665i2 = m6665i(threadArr[i2], list.get(i2), 0, false);
            iM6642d += CodedOutputStream2.m6642d(iM6665i2) + iM6643e + iM6665i2;
        }
        int iM6659c = m6659c(trimmedThrowableData, 1, i);
        int iM6642d2 = CodedOutputStream2.m6642d(iM6659c) + CodedOutputStream2.m6643e(2) + iM6659c + iM6642d;
        int iM6660d = m6660d();
        int iM6642d3 = CodedOutputStream2.m6642d(iM6660d) + CodedOutputStream2.m6643e(3) + iM6660d + iM6642d2;
        int iM6657a = m6657a(byteString2, byteString22);
        return CodedOutputStream2.m6642d(iM6657a) + CodedOutputStream2.m6643e(3) + iM6657a + iM6642d3;
    }

    /* JADX INFO: renamed from: f */
    public static int m6662f(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString2 byteString2, ByteString2 byteString22, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int iM6661e = m6661e(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString2, byteString22);
        int iM6642d = CodedOutputStream2.m6642d(iM6661e) + CodedOutputStream2.m6643e(1) + iM6661e + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int iM6658b = m6658b(entry.getKey(), entry.getValue());
                iM6642d += CodedOutputStream2.m6642d(iM6658b) + CodedOutputStream2.m6643e(2) + iM6658b;
            }
        }
        if (runningAppProcessInfo != null) {
            iM6642d += CodedOutputStream2.m6639a(3, runningAppProcessInfo.importance != 100);
        }
        return CodedOutputStream2.m6644f(4, i2) + iM6642d;
    }

    /* JADX INFO: renamed from: g */
    public static int m6663g(Float f, int i, boolean z2, int i2, long j, long j2) {
        int iM6643e = 0;
        if (f != null) {
            f.floatValue();
            iM6643e = 0 + CodedOutputStream2.m6643e(1) + 4;
        }
        return CodedOutputStream2.m6645h(6, j2) + CodedOutputStream2.m6645h(5, j) + CodedOutputStream2.m6644f(4, i2) + CodedOutputStream2.m6639a(3, z2) + iM6643e + CodedOutputStream2.m6642d((i >> 31) ^ (i << 1)) + CodedOutputStream2.m6643e(2);
    }

    /* JADX INFO: renamed from: h */
    public static int m6664h(StackTraceElement stackTraceElement, boolean z2) {
        int iM6640b = CodedOutputStream2.m6640b(2, ByteString2.m6637a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) + (stackTraceElement.isNativeMethod() ? CodedOutputStream2.m6645h(1, Math.max(stackTraceElement.getLineNumber(), 0)) : CodedOutputStream2.m6645h(1, 0L)) + 0;
        if (stackTraceElement.getFileName() != null) {
            iM6640b += CodedOutputStream2.m6640b(3, ByteString2.m6637a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            iM6640b += CodedOutputStream2.m6645h(4, stackTraceElement.getLineNumber());
        }
        return CodedOutputStream2.m6644f(5, z2 ? 2 : 0) + iM6640b;
    }

    /* JADX INFO: renamed from: i */
    public static int m6665i(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z2) {
        int iM6644f = CodedOutputStream2.m6644f(2, i) + CodedOutputStream2.m6640b(1, ByteString2.m6637a(thread.getName()));
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int iM6664h = m6664h(stackTraceElement, z2);
            iM6644f += CodedOutputStream2.m6642d(iM6664h) + CodedOutputStream2.m6643e(3) + iM6664h;
        }
        return iM6644f;
    }

    /* JADX INFO: renamed from: j */
    public static ByteString2 m6666j(String str) {
        if (str == null) {
            return null;
        }
        return ByteString2.m6637a(str);
    }

    /* JADX INFO: renamed from: k */
    public static void m6667k(CodedOutputStream2 codedOutputStream2, int i, StackTraceElement stackTraceElement, boolean z2) throws Exception {
        codedOutputStream2.m6652o((i << 3) | 2);
        codedOutputStream2.m6652o(m6664h(stackTraceElement, z2));
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream2.m6656t(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream2.m6656t(1, 0L);
        }
        codedOutputStream2.m6649l(2, ByteString2.m6637a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream2.m6649l(3, ByteString2.m6637a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream2.m6656t(4, stackTraceElement.getLineNumber());
        }
        codedOutputStream2.m6655s(5, z2 ? 4 : 0);
    }

    /* JADX INFO: renamed from: l */
    public static void m6668l(CodedOutputStream2 codedOutputStream2, TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) throws Exception {
        codedOutputStream2.m6652o((i3 << 3) | 2);
        codedOutputStream2.m6652o(m6659c(trimmedThrowableData, 1, i2));
        codedOutputStream2.m6649l(1, ByteString2.m6637a(trimmedThrowableData.f12778b));
        String str = trimmedThrowableData.f12777a;
        if (str != null) {
            codedOutputStream2.m6649l(3, ByteString2.m6637a(str));
        }
        int i4 = 0;
        for (StackTraceElement stackTraceElement : trimmedThrowableData.f12779c) {
            m6667k(codedOutputStream2, 4, stackTraceElement, true);
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f12780d;
        if (trimmedThrowableData2 != null) {
            if (i < i2) {
                m6668l(codedOutputStream2, trimmedThrowableData2, i + 1, i2, 6);
                return;
            }
            while (trimmedThrowableData2 != null) {
                trimmedThrowableData2 = trimmedThrowableData2.f12780d;
                i4++;
            }
            codedOutputStream2.m6655s(7, i4);
        }
    }

    /* JADX INFO: renamed from: m */
    public static void m6669m(CodedOutputStream2 codedOutputStream2, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z2) throws Exception {
        codedOutputStream2.m6654r(1, 2);
        codedOutputStream2.m6652o(m6665i(thread, stackTraceElementArr, i, z2));
        codedOutputStream2.m6649l(1, ByteString2.m6637a(thread.getName()));
        codedOutputStream2.m6655s(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            m6667k(codedOutputStream2, 3, stackTraceElement, z2);
        }
    }
}
