package com.discord.utilities.systemlog;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.adjust.sdk.Constants;
import com.discord.utilities.debug.DebugPrintableCollection;
import d0.f0.q;
import d0.g0.c;
import d0.g0.i;
import d0.g0.p;
import d0.g0.t;
import d0.g0.w;
import d0.t.n0;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.e.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import rx.Observable;

/* compiled from: SystemLogUtils.kt */
/* loaded from: classes2.dex */
public final class SystemLogUtils {
    public static final String logcatPath = "/system/bin/logcat";
    private static final int maxLogSize = 2500000;
    private static final Regex regexExtractTombstone;
    public static final SystemLogUtils INSTANCE = new SystemLogUtils();
    private static final DebugPrintableCollection debugPrintables = new DebugPrintableCollection();
    private static final SystemLogCapture systemLogCapture = new SystemLogCapture();

    /* compiled from: SystemLogUtils.kt */
    public static final /* data */ class Tombstone {
        private final String cause;
        private final String groupBy;
        private final String groupHash;
        private final String origin;
        private final String text;
        private final String textHash;

        public Tombstone(String str, String str2, String str3, String str4, String str5, String str6) {
            m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            m.checkNotNullParameter(str3, "groupBy");
            m.checkNotNullParameter(str4, "origin");
            m.checkNotNullParameter(str5, "groupHash");
            m.checkNotNullParameter(str6, "textHash");
            this.text = str;
            this.cause = str2;
            this.groupBy = str3;
            this.origin = str4;
            this.groupHash = str5;
            this.textHash = str6;
        }

        public static /* synthetic */ Tombstone copy$default(Tombstone tombstone, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tombstone.text;
            }
            if ((i & 2) != 0) {
                str2 = tombstone.cause;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = tombstone.groupBy;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = tombstone.origin;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = tombstone.groupHash;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = tombstone.textHash;
            }
            return tombstone.copy(str, str7, str8, str9, str10, str6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCause() {
            return this.cause;
        }

        /* renamed from: component3, reason: from getter */
        public final String getGroupBy() {
            return this.groupBy;
        }

        /* renamed from: component4, reason: from getter */
        public final String getOrigin() {
            return this.origin;
        }

        /* renamed from: component5, reason: from getter */
        public final String getGroupHash() {
            return this.groupHash;
        }

        /* renamed from: component6, reason: from getter */
        public final String getTextHash() {
            return this.textHash;
        }

        public final Tombstone copy(String text, String cause, String groupBy, String origin, String groupHash, String textHash) {
            m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            m.checkNotNullParameter(groupBy, "groupBy");
            m.checkNotNullParameter(origin, "origin");
            m.checkNotNullParameter(groupHash, "groupHash");
            m.checkNotNullParameter(textHash, "textHash");
            return new Tombstone(text, cause, groupBy, origin, groupHash, textHash);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tombstone)) {
                return false;
            }
            Tombstone tombstone = (Tombstone) other;
            return m.areEqual(this.text, tombstone.text) && m.areEqual(this.cause, tombstone.cause) && m.areEqual(this.groupBy, tombstone.groupBy) && m.areEqual(this.origin, tombstone.origin) && m.areEqual(this.groupHash, tombstone.groupHash) && m.areEqual(this.textHash, tombstone.textHash);
        }

        public final String getCause() {
            return this.cause;
        }

        public final String getGroupBy() {
            return this.groupBy;
        }

        public final String getGroupHash() {
            return this.groupHash;
        }

        public final String getOrigin() {
            return this.origin;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTextHash() {
            return this.textHash;
        }

        public int hashCode() {
            String str = this.text;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.cause;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.groupBy;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.origin;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.groupHash;
            int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.textHash;
            return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Tombstone(text=");
            sbU.append(this.text);
            sbU.append(", cause=");
            sbU.append(this.cause);
            sbU.append(", groupBy=");
            sbU.append(this.groupBy);
            sbU.append(", origin=");
            sbU.append(this.origin);
            sbU.append(", groupHash=");
            sbU.append(this.groupHash);
            sbU.append(", textHash=");
            return a.J(sbU, this.textHash, ")");
        }
    }

    /* compiled from: SystemLogUtils.kt */
    /* renamed from: com.discord.utilities.systemlog.SystemLogUtils$fetch$1, reason: invalid class name */
    public static final class AnonymousClass1<V> implements Callable<LinkedList<String>> {
        public final /* synthetic */ Regex $filter;
        public final /* synthetic */ boolean $logErrors;
        public final /* synthetic */ LinkedList $output;

        public AnonymousClass1(LinkedList linkedList, Regex regex, boolean z2) {
            this.$output = linkedList;
            this.$filter = regex;
            this.$logErrors = z2;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ LinkedList<String> call() {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedList<String> call2() {
            Process processStart = null;
            try {
                try {
                    processStart = new ProcessBuilder(SystemLogUtils.logcatPath, "-d").redirectErrorStream(true).start();
                    SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
                    m.checkNotNullExpressionValue(processStart, "logcatProcess");
                    SystemLogUtils.access$waitFor(systemLogUtils, processStart);
                    InputStream inputStream = processStart.getInputStream();
                    m.checkNotNullExpressionValue(inputStream, "logcatProcess.inputStream");
                    Reader inputStreamReader = new InputStreamReader(inputStream, c.a);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    systemLogUtils.processLogs$app_productionGoogleRelease(bufferedReader, this.$output, this.$filter);
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.$logErrors) {
                        this.$output.add("Exception getting system logs '" + e + '\'');
                        StackTraceElement[] stackTrace = e.getStackTrace();
                        m.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            this.$output.add("    " + stackTraceElement);
                        }
                    }
                    if (processStart != null) {
                    }
                }
                processStart.destroy();
                return this.$output;
            } catch (Throwable th) {
                if (processStart != null) {
                    processStart.destroy();
                }
                throw th;
            }
        }
    }

    /* compiled from: SystemLogUtils.kt */
    /* renamed from: com.discord.utilities.systemlog.SystemLogUtils$fetchLastTombstone$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<LinkedList<String>, Observable<? extends Tombstone>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Tombstone> call(LinkedList<String> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Tombstone> call2(LinkedList<String> linkedList) {
            SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
            m.checkNotNullExpressionValue(linkedList, "crashes");
            Tombstone tombstoneFetchLastTombstone$app_productionGoogleRelease = systemLogUtils.fetchLastTombstone$app_productionGoogleRelease(linkedList);
            return tombstoneFetchLastTombstone$app_productionGoogleRelease == null ? j0.l.a.c.k : new k(tombstoneFetchLastTombstone$app_productionGoogleRelease);
        }
    }

    /* compiled from: SystemLogUtils.kt */
    /* renamed from: com.discord.utilities.systemlog.SystemLogUtils$hashString$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Byte, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Byte b2) {
            return invoke(b2.byteValue());
        }

        public final CharSequence invoke(byte b2) {
            return a.P(new Object[]{Byte.valueOf(b2)}, 1, "%02X", "java.lang.String.format(this, *args)");
        }
    }

    static {
        StringBuilder sbU = a.U("(?:^(?:[^\\s]+\\s+){4}F\\s+DEBUG\\s+:\\s(.+))|(^.+(\\[");
        sbU.append(Regex.INSTANCE.escape("libdiscord_version"));
        sbU.append("\\].+))");
        regexExtractTombstone = new Regex(sbU.toString());
    }

    private SystemLogUtils() {
    }

    public static final /* synthetic */ void access$waitFor(SystemLogUtils systemLogUtils, Process process) throws InterruptedException {
        systemLogUtils.waitFor(process);
    }

    private final String hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
        Charset charset = c.a;
        Objects.requireNonNull(input, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = input.getBytes(charset);
        m.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        m.checkNotNullExpressionValue(bArrDigest, "bytes");
        return d0.t.k.joinToString$default(bArrDigest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass1.INSTANCE, 30, (Object) null);
    }

    private final void waitFor(Process process) throws InterruptedException {
        long nanos = TimeUnit.SECONDS.toNanos(15L) + System.nanoTime();
        do {
            try {
                process.exitValue();
                return;
            } catch (IllegalThreadStateException unused) {
                Thread.sleep(100L);
            }
        } while (System.nanoTime() < nanos);
    }

    public final String fetch() {
        StringBuilder sb = new StringBuilder();
        debugPrintables.debugPrint(sb);
        systemLogCapture.appendOutput(sb);
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final Observable<Tombstone> fetchLastTombstone() {
        Observable observableA = fetch(regexExtractTombstone).A(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableA, "fetch(regexExtractTombst…ble.just(tombstone)\n    }");
        return observableA;
    }

    public final Tombstone fetchLastTombstone$app_productionGoogleRelease(Collection<String> crashes) {
        String str;
        List<String> groupValues;
        m.checkNotNullParameter(crashes, "crashes");
        String str2 = null;
        if (crashes.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str3 = null;
        String str4 = null;
        for (String str5 : crashes) {
            if (w.contains$default((CharSequence) str5, (CharSequence) "libdiscord_version", false, 2, (Object) null)) {
                str3 = str5;
            } else {
                if (w.contains$default((CharSequence) str5, (CharSequence) "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***", false, 2, (Object) null)) {
                    p.clear(sb);
                    str4 = str3;
                }
                sb.append(str5);
                m.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                m.checkNotNullExpressionValue(sb, "append('\\n')");
            }
        }
        if (!t.isBlank(sb)) {
            sb.append('\n');
            m.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append("Tombstone's libdiscord_version: ");
            if (str4 == null) {
                str4 = "Unknown libdiscord_version";
            }
            sb.append(str4);
            m.checkNotNullExpressionValue(sb, "append(value)");
            sb.append('\n');
            m.checkNotNullExpressionValue(sb, "append('\\n')");
        }
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "StringBuilder().also { s…\n      }\n    }.toString()");
        if (t.isBlank(string)) {
            return null;
        }
        i iVar = i.MULTILINE;
        Regex regex = new Regex("^Cause: (.+)$", iVar);
        Sequence map = q.map(Regex.findAll$default(new Regex("^\\s+#\\d+ pc .+/(.+? .+?)\\+?[+)]", iVar), string, 0, 2, null), new SystemLogUtils$fetchLastTombstone$extractedGroups$1(new Regex("classes\\d+.dex")));
        HashSet hashSetHashSetOf = n0.hashSetOf("libc.so (abort", "libart.so (art::Runtime::Abort(char const*", "libbase.so (android::base::LogMessage::~LogMessage(");
        try {
        } catch (NoSuchElementException unused) {
            str = "Unknown";
        }
        for (Object obj : map) {
            if (!hashSetHashSetOf.contains((String) obj)) {
                str = (String) obj;
                String strJoinToString$default = q.joinToString$default(map, "\n", null, null, 0, null, null, 62, null);
                MatchResult matchResultFind$default = Regex.find$default(regex, string, 0, 2, null);
                if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                    str2 = groupValues.get(1);
                }
                return new Tombstone(string, str2, strJoinToString$default, str, hashString(strJoinToString$default), hashString(string));
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final DebugPrintableCollection getDebugPrintables$app_productionGoogleRelease() {
        return debugPrintables;
    }

    public final Regex getRegexExtractTombstone$app_productionGoogleRelease() {
        return regexExtractTombstone;
    }

    public final Thread initSystemLogCapture() {
        return systemLogCapture.startThread();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        throw new java.util.NoSuchElementException("List contains no element matching the predicate.");
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void processLogs$app_productionGoogleRelease(BufferedReader reader, LinkedList<String> output, Regex filter) {
        m.checkNotNullParameter(reader, "reader");
        m.checkNotNullParameter(output, "output");
        int i = 0;
        loop0: while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                if (filter != null) {
                    MatchResult matchResultFind$default = Regex.find$default(filter, line, 0, 2, null);
                    if (matchResultFind$default != null) {
                        List<String> groupValues = matchResultFind$default.getGroupValues();
                        ListIterator<String> listIterator = groupValues.listIterator(groupValues.size());
                        while (listIterator.hasPrevious()) {
                            String strPrevious = listIterator.previous();
                            if (strPrevious.length() > 0) {
                                line = strPrevious;
                            }
                        }
                        break loop0;
                    }
                    continue;
                }
                if (!t.isBlank(line) && !w.contains$default((CharSequence) line, (CharSequence) "Accessing hidden method", false, 2, (Object) null)) {
                    int length = line.length() + 1 + i;
                    try {
                        output.add(line);
                        if (length > maxLogSize) {
                            length -= output.pop().length() - 1;
                        }
                        i = length;
                    } catch (Exception e) {
                        e = e;
                        i = length;
                        e.printStackTrace();
                        if (filter == null) {
                            output.add("IOException: " + e);
                        }
                        if (i <= maxLogSize) {
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (i <= maxLogSize) {
            output.pop().length();
        }
    }

    private final Observable<LinkedList<String>> fetch(Regex filter) {
        LinkedList linkedList = new LinkedList();
        boolean z2 = filter == null;
        if (!new File(logcatPath).exists()) {
            if (z2) {
                linkedList.add("Unable to locate '/system/bin/logcat'");
            }
            k kVar = new k(linkedList);
            m.checkNotNullExpressionValue(kVar, "Observable.just(output)");
            return kVar;
        }
        Observable<LinkedList<String>> observableX = Observable.D(new AnonymousClass1(linkedList, filter, z2)).X(j0.p.a.b().d);
        m.checkNotNullExpressionValue(observableX, "Observable.fromCallable …n(Schedulers.newThread())");
        return observableX;
    }
}
