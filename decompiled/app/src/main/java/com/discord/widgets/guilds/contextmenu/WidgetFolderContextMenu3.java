package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFolderContextMenu3 extends FunctionReferenceImpl implements Function1<View, WidgetFolderContextMenuBinding> {
    public static final WidgetFolderContextMenu3 INSTANCE = new WidgetFolderContextMenu3();

    public WidgetFolderContextMenu3() {
        super(1, WidgetFolderContextMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFolderContextMenuBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFolderContextMenuBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetFolderContextMenuBinding.m8414a(view);
    }
}
