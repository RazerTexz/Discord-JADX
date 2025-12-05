package androidx.preference;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* compiled from: PreferenceGroup.kt */
/* renamed from: androidx.preference.PreferenceGroupKt$children$1, reason: use source file name */
/* loaded from: classes.dex */
public final class PreferenceGroup3 implements Sequence<Preference> {
    public final /* synthetic */ PreferenceGroup $this_children;

    public PreferenceGroup3(PreferenceGroup preferenceGroup) {
        this.$this_children = preferenceGroup;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Preference> iterator() {
        return PreferenceGroup2.iterator(this.$this_children);
    }
}
