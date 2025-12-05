package androidx.preference;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: PreferenceGroup.kt */
/* renamed from: androidx.preference.PreferenceGroupKt, reason: use source file name */
/* loaded from: classes.dex */
public final class PreferenceGroup2 {

    /* compiled from: PreferenceGroup.kt */
    /* renamed from: androidx.preference.PreferenceGroupKt$iterator$1 */
    public static final class C05231 implements Iterator<Preference>, KMarkers {
        public final /* synthetic */ PreferenceGroup $this_iterator;
        private int index;

        public C05231(PreferenceGroup preferenceGroup) {
            this.$this_iterator = preferenceGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getPreferenceCount();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Preference next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            PreferenceGroup preferenceGroup = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            preferenceGroup.removePreference(preferenceGroup.getPreference(i));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Preference next() {
            PreferenceGroup preferenceGroup = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            Preference preference = preferenceGroup.getPreference(i);
            if (preference != null) {
                return preference;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$contains");
        Intrinsics3.checkParameterIsNotNull(preference, "preference");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            if (Intrinsics3.areEqual(preferenceGroup.getPreference(i), preference)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(PreferenceGroup preferenceGroup, Function1<? super Preference, Unit> function1) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$forEach");
        Intrinsics3.checkParameterIsNotNull(function1, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function1.invoke(get(preferenceGroup, i));
        }
    }

    public static final void forEachIndexed(PreferenceGroup preferenceGroup, Function2<? super Integer, ? super Preference, Unit> function2) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$forEachIndexed");
        Intrinsics3.checkParameterIsNotNull(function2, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function2.invoke(Integer.valueOf(i), get(preferenceGroup, i));
        }
    }

    public static final <T extends Preference> T get(PreferenceGroup preferenceGroup, CharSequence charSequence) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$get");
        Intrinsics3.checkParameterIsNotNull(charSequence, "key");
        return (T) preferenceGroup.findPreference(charSequence);
    }

    public static final Sequence<Preference> getChildren(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$children");
        return new PreferenceGroup3(preferenceGroup);
    }

    public static final int getSize(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$size");
        return preferenceGroup.getPreferenceCount();
    }

    public static final boolean isEmpty(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$isEmpty");
        return preferenceGroup.getPreferenceCount() == 0;
    }

    public static final boolean isNotEmpty(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$isNotEmpty");
        return preferenceGroup.getPreferenceCount() != 0;
    }

    public static final Iterator<Preference> iterator(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$iterator");
        return new C05231(preferenceGroup);
    }

    public static final void minusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$minusAssign");
        Intrinsics3.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.removePreference(preference);
    }

    public static final void plusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$plusAssign");
        Intrinsics3.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.addPreference(preference);
    }

    public static final Preference get(PreferenceGroup preferenceGroup, int i) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$get");
        Preference preference = preferenceGroup.getPreference(i);
        if (preference != null) {
            return preference;
        }
        StringBuilder sbM834V = outline.m834V("Index: ", i, ", Size: ");
        sbM834V.append(preferenceGroup.getPreferenceCount());
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }
}
