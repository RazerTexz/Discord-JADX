package com.discord.widgets.chat.input;

import com.discord.models.commands.Application;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatInputCategoriesAdapter.kt */
/* renamed from: com.discord.widgets.chat.input.CommandCategoryItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetChatInputCategoriesAdapter3 {
    private final Application application;
    private final boolean isSelected;

    public WidgetChatInputCategoriesAdapter3(Application application, boolean z2) {
        Intrinsics3.checkNotNullParameter(application, "application");
        this.application = application;
        this.isSelected = z2;
    }

    public static /* synthetic */ WidgetChatInputCategoriesAdapter3 copy$default(WidgetChatInputCategoriesAdapter3 widgetChatInputCategoriesAdapter3, Application application, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            application = widgetChatInputCategoriesAdapter3.application;
        }
        if ((i & 2) != 0) {
            z2 = widgetChatInputCategoriesAdapter3.isSelected;
        }
        return widgetChatInputCategoriesAdapter3.copy(application, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final WidgetChatInputCategoriesAdapter3 copy(Application application, boolean isSelected) {
        Intrinsics3.checkNotNullParameter(application, "application");
        return new WidgetChatInputCategoriesAdapter3(application, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatInputCategoriesAdapter3)) {
            return false;
        }
        WidgetChatInputCategoriesAdapter3 widgetChatInputCategoriesAdapter3 = (WidgetChatInputCategoriesAdapter3) other;
        return Intrinsics3.areEqual(this.application, widgetChatInputCategoriesAdapter3.application) && this.isSelected == widgetChatInputCategoriesAdapter3.isSelected;
    }

    public final Application getApplication() {
        return this.application;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        boolean z2 = this.isSelected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CommandCategoryItem(application=");
        sbM833U.append(this.application);
        sbM833U.append(", isSelected=");
        return outline.m827O(sbM833U, this.isSelected, ")");
    }
}
