package p615g0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;
import p507d0.p580t.AbstractList;
import p507d0.p580t.Collections2;
import p507d0.p580t.MutableCollectionsJVM;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Options.kt */
/* renamed from: g0.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class Options2 extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: k */
    public static final a f26106k = new a(null);

    /* renamed from: l */
    public final ByteString[] f26107l;

    /* renamed from: m */
    public final int[] f26108m;

    /* compiled from: Options.kt */
    /* renamed from: g0.o$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final void m10489a(long j, Buffer3 buffer3, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) throws IOException {
            int i4;
            int i5;
            int i6;
            int i7;
            Buffer3 buffer32;
            int i8 = i;
            if (!(i2 < i3)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i9 = i2; i9 < i3; i9++) {
                if (!(list.get(i9).mo10502j() >= i8)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            if (i8 == byteString.mo10502j()) {
                int iIntValue = list2.get(i2).intValue();
                int i10 = i2 + 1;
                ByteString byteString3 = list.get(i10);
                i4 = i10;
                i5 = iIntValue;
                byteString = byteString3;
            } else {
                i4 = i2;
                i5 = -1;
            }
            if (byteString.mo10505m(i8) == byteString2.mo10505m(i8)) {
                int iMin = Math.min(byteString.mo10502j(), byteString2.mo10502j());
                int i11 = 0;
                for (int i12 = i8; i12 < iMin && byteString.mo10505m(i12) == byteString2.mo10505m(i12); i12++) {
                    i11++;
                }
                long jM10490b = m10490b(buffer3) + j + 2 + i11 + 1;
                buffer3.m10447W(-i11);
                buffer3.m10447W(i5);
                int i13 = i8 + i11;
                while (i8 < i13) {
                    buffer3.m10447W(byteString.mo10505m(i8) & 255);
                    i8++;
                }
                if (i4 + 1 == i3) {
                    if (!(i13 == list.get(i4).mo10502j())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    buffer3.m10447W(list2.get(i4).intValue());
                    return;
                } else {
                    Buffer3 buffer33 = new Buffer3();
                    buffer3.m10447W(((int) (m10490b(buffer33) + jM10490b)) * (-1));
                    m10489a(jM10490b, buffer33, i13, list, i4, i3, list2);
                    buffer3.mo10440P(buffer33);
                    return;
                }
            }
            int i14 = 1;
            for (int i15 = i4 + 1; i15 < i3; i15++) {
                if (list.get(i15 - 1).mo10505m(i8) != list.get(i15).mo10505m(i8)) {
                    i14++;
                }
            }
            long jM10490b2 = m10490b(buffer3) + j + 2 + (i14 * 2);
            buffer3.m10447W(i14);
            buffer3.m10447W(i5);
            for (int i16 = i4; i16 < i3; i16++) {
                byte bMo10505m = list.get(i16).mo10505m(i8);
                if (i16 == i4 || bMo10505m != list.get(i16 - 1).mo10505m(i8)) {
                    buffer3.m10447W(bMo10505m & 255);
                }
            }
            Buffer3 buffer34 = new Buffer3();
            while (i4 < i3) {
                byte bMo10505m2 = list.get(i4).mo10505m(i8);
                int i17 = i4 + 1;
                int i18 = i17;
                while (true) {
                    if (i18 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (bMo10505m2 != list.get(i18).mo10505m(i8)) {
                            i6 = i18;
                            break;
                        }
                        i18++;
                    }
                }
                if (i17 == i6 && i8 + 1 == list.get(i4).mo10502j()) {
                    buffer3.m10447W(list2.get(i4).intValue());
                    i7 = i6;
                    buffer32 = buffer34;
                } else {
                    buffer3.m10447W(((int) (m10490b(buffer34) + jM10490b2)) * (-1));
                    i7 = i6;
                    buffer32 = buffer34;
                    m10489a(jM10490b2, buffer34, i8 + 1, list, i4, i6, list2);
                }
                buffer34 = buffer32;
                i4 = i7;
            }
            buffer3.mo10440P(buffer34);
        }

        /* renamed from: b */
        public final long m10490b(Buffer3 buffer3) {
            return buffer3.f26080k / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x00fa, code lost:
        
            continue;
         */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Options2 m10491c(ByteString... byteStringArr) throws IOException {
            Intrinsics3.checkParameterIsNotNull(byteStringArr, "byteStrings");
            int i = 0;
            if (byteStringArr.length == 0) {
                return new Options2(new ByteString[0], new int[]{0, -1}, null);
            }
            List<? extends ByteString> mutableList = _Arrays.toMutableList(byteStringArr);
            MutableCollectionsJVM.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStringArr.length);
            for (ByteString byteString : byteStringArr) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Integer[] numArr = (Integer[]) array;
            List<Integer> listMutableListOf = Collections2.mutableListOf((Integer[]) Arrays.copyOf(numArr, numArr.length));
            int length = byteStringArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                listMutableListOf.set(Collections2.binarySearch$default(mutableList, byteStringArr[i2], 0, 0, 6, null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (!(mutableList.get(0).mo10502j() > 0)) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            int i4 = 0;
            while (i4 < mutableList.size()) {
                ByteString byteString2 = mutableList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < mutableList.size()) {
                    ByteString byteString3 = mutableList.get(i6);
                    Objects.requireNonNull(byteString3);
                    Intrinsics3.checkParameterIsNotNull(byteString2, "prefix");
                    if (!byteString3.mo10506n(0, byteString2, 0, byteString2.mo10502j())) {
                        break;
                    }
                    if (!(byteString3.mo10502j() != byteString2.mo10502j())) {
                        throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                    }
                    if (listMutableListOf.get(i6).intValue() > listMutableListOf.get(i4).intValue()) {
                        mutableList.remove(i6);
                        listMutableListOf.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            Buffer3 buffer3 = new Buffer3();
            m10489a(0L, buffer3, 0, mutableList, 0, mutableList.size(), listMutableListOf);
            int[] iArr = new int[(int) m10490b(buffer3)];
            while (!buffer3.mo10472w()) {
                iArr[i] = buffer3.readInt();
                i++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStringArr, byteStringArr.length);
            Intrinsics3.checkExpressionValueIsNotNull(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new Options2((ByteString[]) objArrCopyOf, iArr, null);
        }
    }

    public Options2(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.f26107l = byteStringArr;
        this.f26108m = iArr;
    }

    @Override // p507d0.p580t.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // p507d0.p580t.AbstractList, java.util.List
    public Object get(int i) {
        return this.f26107l[i];
    }

    @Override // p507d0.p580t.AbstractCollection
    public int getSize() {
        return this.f26107l.length;
    }

    @Override // p507d0.p580t.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // p507d0.p580t.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }
}
