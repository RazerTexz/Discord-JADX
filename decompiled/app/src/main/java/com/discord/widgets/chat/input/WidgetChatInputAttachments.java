package com.discord.widgets.chat.input;

import android.content.ContentResolver;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.chat.input.expression.WidgetExpressionTray;
import com.google.android.material.button.MaterialButton;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.fragment.FilesFragment;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.fragment.MediaFragment;
import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.WidgetChatInputPermReqFilesBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p076b.p077a.p079d.AddContentPagerAdapter4;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments {
    private final FlexInputFragment flexInputFragment;

    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class DiscordFilesFragment extends FilesFragment {
        @Override // com.lytefast.flexinput.fragment.FilesFragment
        public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
            Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
            return new PermissionsEmptyListAdapter(C5419R.layout.widget_chat_input_perm_req_files, C5419R.id.action_btn, onClickListener);
        }
    }

    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class DiscordMediaFragment extends MediaFragment {
        @Override // com.lytefast.flexinput.fragment.MediaFragment
        public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
            Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
            return new PermissionsEmptyListAdapter(C5419R.layout.widget_chat_input_perm_req_files, C5419R.id.action_btn, onClickListener);
        }
    }

    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class PermissionsEmptyListAdapter extends EmptyListAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionsEmptyListAdapter(@LayoutRes int i, @IdRes int i2, View.OnClickListener onClickListener) {
            super(i, i2, onClickListener);
            Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        }

        @Override // com.lytefast.flexinput.adapters.EmptyListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // com.lytefast.flexinput.adapters.EmptyListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public EmptyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            EmptyListAdapter.ViewHolder viewHolderOnCreateViewHolder = super.onCreateViewHolder(parent, viewType);
            View view = viewHolderOnCreateViewHolder.itemView;
            int i = C5419R.id.action_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.action_btn);
            if (materialButton != null) {
                i = C5419R.id.perm_req_text;
                TextView textView = (TextView) view.findViewById(C5419R.id.perm_req_text);
                if (textView != null) {
                    Intrinsics3.checkNotNullExpressionValue(new WidgetChatInputPermReqFilesBinding((LinearLayout) view, materialButton, textView), "WidgetChatInputPermReqFi…ing.bind(holder.itemView)");
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.permReqText");
                    FormatUtils.m222n(textView, C5419R.string.system_permission_request_files, new Object[0], null, 4);
                    return viewHolderOnCreateViewHolder;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$addExternalAttachment$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77351 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Attachment $attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77351(Attachment attachment) {
            super(0);
            this.$attachment = attachment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).mo397f(this.$attachment);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77361 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $canCreateThread;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77361(boolean z2) {
            super(0);
            this.$canCreateThread = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Context contextRequireContext = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "flexInputFragment.requireContext()");
            List listMutableListOf = Collections2.mutableListOf(new C7738xcc8c6858(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C5419R.attr.ic_flex_input_image, 0, 2, (Object) null), C5419R.string.attachment_media), new C7739xcc8c6859(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C5419R.attr.ic_flex_input_file, 0, 2, (Object) null), C5419R.string.attachment_files), new C7740xcc8c685a(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C5419R.attr.ic_flex_input_add_a_photo, 0, 2, (Object) null), C5419R.string.camera));
            if (this.$canCreateThread) {
                listMutableListOf.add(new C7737x3eddd7b(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C5419R.attr.ic_flex_input_create_thread, 0, 2, (Object) null), C5419R.string.create_thread));
            }
            FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this);
            Object[] array = listMutableListOf.toArray(new AddContentPagerAdapter4.a[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            AddContentPagerAdapter4.a[] aVarArr = (AddContentPagerAdapter4.a[]) array;
            Objects.requireNonNull(flexInputFragmentAccess$getFlexInputFragment$p);
            Intrinsics3.checkNotNullParameter(aVarArr, "pageSuppliers");
            flexInputFragmentAccess$getFlexInputFragment$p.f22062r = aVarArr;
            Iterator<Function0<Unit>> it = flexInputFragmentAccess$getFlexInputFragment$p.onContentPagesInitializedUpdates.iterator();
            while (it.hasNext()) {
                it.next().invoke();
            }
            flexInputFragmentAccess$getFlexInputFragment$p.onContentPagesInitializedUpdates.clear();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77411 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppFragment $fragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77411(AppFragment appFragment) {
            super(0);
            this.$fragment = appFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputAttachments.this.configureFlexInputContentPages(false);
            FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this);
            FileManager fileManager = this.$fragment.getFileManager();
            Objects.requireNonNull(flexInputFragmentAccess$getFlexInputFragment$p);
            Intrinsics3.checkNotNullParameter(fileManager, "<set-?>");
            flexInputFragmentAccess$getFlexInputFragment$p.fileManager = fileManager;
            flexInputFragmentAccess$getFlexInputFragment$p.keyboardManager = new C7742xe5e506b2(this);
            WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).m9293l().setInputContentHandler(new C7743xe5e506b3(this));
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapterAccess$createPreviewAdapter = WidgetChatInputAttachments.access$createPreviewAdapter(WidgetChatInputAttachments.this, this.$fragment.getContext());
            Intrinsics3.checkNotNullParameter(attachmentPreviewAdapterAccess$createPreviewAdapter, "previewAdapter");
            attachmentPreviewAdapterAccess$createPreviewAdapter.selectionAggregator.initFrom(flexInputFragmentAccess$getFlexInputFragment$p.mo396b());
            flexInputFragmentAccess$getFlexInputFragment$p.attachmentPreviewAdapter = attachmentPreviewAdapterAccess$createPreviewAdapter;
            RecyclerView recyclerView = flexInputFragmentAccess$getFlexInputFragment$p.m9291j().f2175d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.attachmentPreviewList");
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = flexInputFragmentAccess$getFlexInputFragment$p.attachmentPreviewAdapter;
            if (attachmentPreviewAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
            }
            recyclerView.setAdapter(attachmentPreviewAdapter);
            WidgetChatInputAttachments widgetChatInputAttachments = WidgetChatInputAttachments.this;
            FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            Fragment fragmentAccess$createAndConfigureExpressionFragment = WidgetChatInputAttachments.access$createAndConfigureExpressionFragment(widgetChatInputAttachments, childFragmentManager, WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).m9293l());
            if (fragmentAccess$createAndConfigureExpressionFragment == null) {
                return;
            }
            flexInputFragmentAccess$getFlexInputFragment$p.getChildFragmentManager().beginTransaction().replace(C11170R.f.expression_tray_container, fragmentAccess$createAndConfigureExpressionFragment, fragmentAccess$createAndConfigureExpressionFragment.getClass().getSimpleName()).commit();
            AppCompatImageButton appCompatImageButton = flexInputFragmentAccess$getFlexInputFragment$p.m9291j().f2180i;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
            appCompatImageButton.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$2 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77442<R> implements Func0<Boolean> {
        public C77442() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).viewModel;
            Boolean boolValueOf = flexInputViewModel != null ? Boolean.valueOf(flexInputViewModel.hideExpressionTray()) : null;
            return boolValueOf != null ? boolValueOf : Boolean.FALSE;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77451 extends Lambda implements Function0<Unit> {
        public C77451() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).viewModel;
            if (flexInputViewModel != null) {
                flexInputViewModel.hideExpressionTray();
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77491<T> extends Lambda implements Function1<AttachmentPreviewAdapter<T>, SelectionAggregator<T>> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
        public static final class AnonymousClass1 extends SelectionAggregator<T> {
            public final /* synthetic */ AttachmentPreviewAdapter $previewAdapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AttachmentPreviewAdapter attachmentPreviewAdapter, AttachmentPreviewAdapter attachmentPreviewAdapter2) {
                super(attachmentPreviewAdapter2, null, null, null, 14, null);
                this.$previewAdapter = attachmentPreviewAdapter;
            }

            public static final /* synthetic */ void access$track(AnonymousClass1 anonymousClass1, Attachment attachment) {
                anonymousClass1.track(attachment);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)V */
            private final void track(Attachment attachment) {
                String source = attachment instanceof SourcedAttachment ? ((SourcedAttachment) attachment).getSource() : AnalyticsTracker.ATTACHMENT_SOURCE_PICKER;
                try {
                    int size = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).mo396b().getSize();
                    Context context = C77491.this.$context;
                    AnalyticsTracker.addAttachment(source, AttachmentUtils.getMimeType(attachment, context != null ? context.getContentResolver() : null), size);
                } catch (Throwable th) {
                    AppLog.f14950g.mo8367i("Analytic error on attachment update", th);
                }
            }

            @Override // com.lytefast.flexinput.utils.SelectionAggregator
            public void registerSelectionCoordinatorInternal(SelectionCoordinator<T, ?> selectionCoordinator) {
                Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
                super.registerSelectionCoordinatorInternal(selectionCoordinator);
                C7750x30afbd36 c7750x30afbd36 = new C7750x30afbd36(this, selectionCoordinator.itemSelectionListener);
                Intrinsics3.checkNotNullParameter(c7750x30afbd36, "<set-?>");
                selectionCoordinator.itemSelectionListener = c7750x30afbd36;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77491(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((AttachmentPreviewAdapter) obj);
        }

        public final SelectionAggregator<T> invoke(AttachmentPreviewAdapter<T> attachmentPreviewAdapter) {
            Intrinsics3.checkNotNullParameter(attachmentPreviewAdapter, "previewAdapter");
            return new AnonymousClass1(attachmentPreviewAdapter, attachmentPreviewAdapter);
        }
    }

    public WidgetChatInputAttachments(FlexInputFragment flexInputFragment) {
        Intrinsics3.checkNotNullParameter(flexInputFragment, "flexInputFragment");
        this.flexInputFragment = flexInputFragment;
    }

    public static final /* synthetic */ Fragment access$createAndConfigureExpressionFragment(WidgetChatInputAttachments widgetChatInputAttachments, FragmentManager fragmentManager, TextView textView) {
        return widgetChatInputAttachments.createAndConfigureExpressionFragment(fragmentManager, textView);
    }

    public static final /* synthetic */ AttachmentPreviewAdapter access$createPreviewAdapter(WidgetChatInputAttachments widgetChatInputAttachments, Context context) {
        return widgetChatInputAttachments.createPreviewAdapter(context);
    }

    public static final /* synthetic */ FlexInputFragment access$getFlexInputFragment$p(WidgetChatInputAttachments widgetChatInputAttachments) {
        return widgetChatInputAttachments.flexInputFragment;
    }

    public static final /* synthetic */ void access$setAttachmentFromPicker(WidgetChatInputAttachments widgetChatInputAttachments, Context context, InputContentInfoCompat inputContentInfoCompat) {
        widgetChatInputAttachments.setAttachmentFromPicker(context, inputContentInfoCompat);
    }

    private final Fragment createAndConfigureExpressionFragment(FragmentManager fragmentManager, TextView chatInput) {
        C7746x3e888ca6 c7746x3e888ca6 = new C7746x3e888ca6(this);
        C7748x23c575d c7748x23c575d = new C7748x23c575d(this);
        C7747xeb2e4292 c7747xeb2e4292 = new C7747xeb2e4292(chatInput);
        Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(C5419R.id.expression_tray_container);
        if (!(fragmentFindFragmentById instanceof WidgetExpressionTray)) {
            fragmentFindFragmentById = null;
        }
        WidgetExpressionTray widgetExpressionTray = (WidgetExpressionTray) fragmentFindFragmentById;
        if (widgetExpressionTray == null) {
            widgetExpressionTray = new WidgetExpressionTray();
        }
        widgetExpressionTray.setEmojiPickerListener(c7746x3e888ca6);
        widgetExpressionTray.setStickerPickerListener(c7748x23c575d);
        widgetExpressionTray.setOnBackspacePressedListener(c7747xeb2e4292);
        widgetExpressionTray.setOnEmojiSearchOpenedListener(new C77451());
        return widgetExpressionTray;
    }

    private final <T extends Attachment<? extends Object>> AttachmentPreviewAdapter<T> createPreviewAdapter(Context context) {
        C7751xc61f589 c7751xc61f589 = new C7751xc61f589(this);
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_android_attachment_bottom_sheet", true);
        return new AttachmentPreviewAdapter<>(userExperiment != null && userExperiment.getBucket() == 1, c7751xc61f589, new C77491(context));
    }

    private final void setAttachmentFromPicker(Context context, InputContentInfoCompat inputContentInfoCompat) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            this.flexInputFragment.mo397f(new SourcedAttachment(Attachment.INSTANCE.m9297c(inputContentInfoCompat, contentResolver, true, FormatUtils.m216h(context, C5419R.string.attachment_filename_unknown, new Object[0], null, 4).toString()), AnalyticsTracker.ATTACHMENT_SOURCE_KEYBOARD));
        }
    }

    public final void addExternalAttachment(Attachment<? extends Object> attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        this.flexInputFragment.m9290i(new C77351(attachment));
    }

    public final void configureFlexInputContentPages(boolean canCreateThread) {
        this.flexInputFragment.m9290i(new C77361(canCreateThread));
    }

    public final void configureFlexInputFragment(AppFragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        this.flexInputFragment.m9290i(new C77411(fragment));
        fragment.setOnBackPressed(new C77442(), 1);
    }

    public final void setInputListener(FlexInputListener inputListener) {
        Intrinsics3.checkNotNullParameter(inputListener, "inputListener");
        FlexInputFragment flexInputFragment = this.flexInputFragment;
        Objects.requireNonNull(flexInputFragment);
        Intrinsics3.checkNotNullParameter(inputListener, "inputListener");
        flexInputFragment.inputListener = inputListener;
    }

    public final void setViewModel(FlexInputViewModel viewModel) {
        this.flexInputFragment.viewModel = viewModel;
    }
}
