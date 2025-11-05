package com.discord.models.hubs;

import android.content.Context;
import androidx.annotation.StringRes;
import com.discord.R;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DirectoryEntryCategory.kt */
/* loaded from: classes.dex */
public enum DirectoryEntryCategory {
    Home(-1, R.string.directory_category_all, 70),
    Uncategorized(0, R.string.uncategorized, 0, 4, null),
    SchoolClub(1, R.string.directory_category_school_club, 100),
    Class(2, R.string.directory_category_class, 0, 4, null),
    StudySocial(3, R.string.directory_category_study_social, 50),
    SubjectMajor(4, R.string.directory_category_subject_major, 0, 4, null),
    Misc(5, R.string.directory_category_miscellaneous, 0, 4, null),
    HQSocial(1, R.string.directory_category_internal_1, 0, 4, null),
    HQErgs(2, R.string.directory_category_internal_2, 0, 4, null),
    HQMisc(3, R.string.directory_category_internal_3, 0, 4, null),
    HQArchives(5, R.string.directory_category_internal_5, 0, 4, null);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int idealSize;
    private final int key;
    private final int titleRes;

    /* compiled from: DirectoryEntryCategory.kt */
    public static final class Companion {
        private Companion() {
        }

        public final DirectoryEntryCategory findByKey(int key, boolean isHQDirectoryChannel) {
            Object next;
            Iterator<T> it = getCategories(isHQDirectoryChannel).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((DirectoryEntryCategory) next).getKey() == key) {
                    break;
                }
            }
            DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) next;
            return directoryEntryCategory != null ? directoryEntryCategory : DirectoryEntryCategory.Uncategorized;
        }

        public final List<DirectoryEntryCategory> getCategories(boolean isHQDirectoryChannel) {
            return isHQDirectoryChannel ? DirectoryEntryCategoryKt.access$getHQ_DIRECTORY_CATEGORIES$p() : DirectoryEntryCategoryKt.access$getHUB_CATEGORIES$p();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    DirectoryEntryCategory(int i, @StringRes int i2, int i3) {
        this.key = i;
        this.titleRes = i2;
        this.idealSize = i3;
    }

    public final int getIdealSize() {
        return this.idealSize;
    }

    public final int getKey() {
        return this.key;
    }

    public final String getTitle(Context context) {
        m.checkNotNullParameter(context, "context");
        String string = context.getString(this.titleRes);
        m.checkNotNullExpressionValue(string, "context.getString(titleRes)");
        return string;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    /* synthetic */ DirectoryEntryCategory(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? Integer.MAX_VALUE : i3);
    }
}
