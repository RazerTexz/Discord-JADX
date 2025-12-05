package com.lytefast.flexinput.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.adapters.FileListAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import java.io.File;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p076b.p077a.FlexInputCoordinator;
import p007b.p076b.p077a.p078a.FilesFragment2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: FilesFragment.kt */
/* loaded from: classes3.dex */
public class FilesFragment extends Fragment {
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private FileListAdapter adapter;
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    /* compiled from: FilesFragment.kt */
    /* renamed from: com.lytefast.flexinput.fragment.FilesFragment$a */
    public static final class ViewOnClickListenerC11179a implements View.OnClickListener {

        /* renamed from: j */
        public final /* synthetic */ View f22051j;

        /* renamed from: k */
        public final /* synthetic */ FilesFragment f22052k;

        /* renamed from: l */
        public final /* synthetic */ FlexInputCoordinator f22053l;

        /* compiled from: FilesFragment.kt */
        /* renamed from: com.lytefast.flexinput.fragment.FilesFragment$a$a */
        public static final class a extends Lambda implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ContentResolver contentResolver;
                Context context = ViewOnClickListenerC11179a.this.f22051j.getContext();
                if (context != null && (contentResolver = context.getContentResolver()) != null) {
                    FilesFragment filesFragment = ViewOnClickListenerC11179a.this.f22052k;
                    SelectionCoordinator selectionCoordinatorAccess$getSelectionCoordinator$p = FilesFragment.access$getSelectionCoordinator$p(filesFragment);
                    Intrinsics3.checkNotNull(selectionCoordinatorAccess$getSelectionCoordinator$p);
                    FilesFragment.access$setAdapter$p(filesFragment, new FileListAdapter(contentResolver, selectionCoordinatorAccess$getSelectionCoordinator$p));
                    RecyclerView recyclerView = ViewOnClickListenerC11179a.this.f22052k.getRecyclerView();
                    if (recyclerView != null) {
                        recyclerView.setAdapter(FilesFragment.access$getAdapter$p(ViewOnClickListenerC11179a.this.f22052k));
                    }
                    FilesFragment.access$loadDownloadFolder(ViewOnClickListenerC11179a.this.f22052k);
                }
                return Unit.f27425a;
            }
        }

        public ViewOnClickListenerC11179a(View view, FilesFragment filesFragment, FlexInputCoordinator flexInputCoordinator) {
            this.f22051j = view;
            this.f22052k = filesFragment;
            this.f22053l = flexInputCoordinator;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FlexInputCoordinator flexInputCoordinator = this.f22053l;
            if (flexInputCoordinator != null) {
                flexInputCoordinator.requestMediaPermissions(new a());
            }
        }
    }

    /* compiled from: FilesFragment.kt */
    /* renamed from: com.lytefast.flexinput.fragment.FilesFragment$b */
    public static final /* synthetic */ class C11180b extends FunctionReferenceImpl implements Function0<Unit> {
        public C11180b(FilesFragment filesFragment) {
            super(0, filesFragment, FilesFragment.class, "loadDownloadFolder", "loadDownloadFolder()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            FilesFragment.access$loadDownloadFolder((FilesFragment) this.receiver);
            return Unit.f27425a;
        }
    }

    public static final /* synthetic */ FileListAdapter access$getAdapter$p(FilesFragment filesFragment) {
        return filesFragment.adapter;
    }

    public static final /* synthetic */ SelectionCoordinator access$getSelectionCoordinator$p(FilesFragment filesFragment) {
        return filesFragment.selectionCoordinator;
    }

    public static final /* synthetic */ void access$loadDownloadFolder(FilesFragment filesFragment) {
        filesFragment.loadDownloadFolder();
    }

    public static final /* synthetic */ void access$setAdapter$p(FilesFragment filesFragment, FileListAdapter fileListAdapter) {
        filesFragment.adapter = fileListAdapter;
    }

    public static final /* synthetic */ void access$setSelectionCoordinator$p(FilesFragment filesFragment, SelectionCoordinator selectionCoordinator) {
        filesFragment.selectionCoordinator = selectionCoordinator;
    }

    private final boolean hasPermissions(String... requiredPermissionList) {
        int length = requiredPermissionList.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            if (!(ContextCompat.checkSelfPermission(requireContext(), requiredPermissionList[i]) == 0)) {
                return false;
            }
            i++;
        }
    }

    private final void loadDownloadFolder() {
        if (this.adapter == null) {
            SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
            Intrinsics3.checkNotNull(swipeRefreshLayout);
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        FileListAdapter fileListAdapter = this.adapter;
        Intrinsics3.checkNotNull(fileListAdapter);
        Intrinsics3.checkNotNullExpressionValue(externalStoragePublicDirectory, "downloadFolder");
        Objects.requireNonNull(fileListAdapter);
        Intrinsics3.checkNotNullParameter(externalStoragePublicDirectory, "root");
        new FileListAdapter.AsyncTaskC11173a(fileListAdapter).execute(externalStoragePublicDirectory);
        SwipeRefreshLayout swipeRefreshLayout2 = this.swipeRefreshLayout;
        Intrinsics3.checkNotNull(swipeRefreshLayout2);
        swipeRefreshLayout2.setRefreshing(false);
    }

    /* renamed from: getRecyclerView$flexinput_release, reason: from getter */
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        return new EmptyListAdapter(C11170R.g.item_permission_storage, C11170R.f.permissions_req_btn, onClickListener);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        this.selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        Fragment parentFragment = getParentFragment();
        ActivityResultCaller parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof FlexInputCoordinator)) {
            parentFragment2 = null;
        }
        FlexInputCoordinator flexInputCoordinator = (FlexInputCoordinator) parentFragment2;
        if (flexInputCoordinator != null) {
            SelectionAggregator selectionAggregatorMo396b = flexInputCoordinator.mo396b();
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator = this.selectionCoordinator;
            Intrinsics3.checkNotNull(selectionCoordinator);
            selectionAggregatorMo396b.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(C11170R.g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(C11170R.f.list);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            Context context = viewInflate.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator2 = this.selectionCoordinator;
            Intrinsics3.checkNotNull(selectionCoordinator2);
            FileListAdapter fileListAdapter = new FileListAdapter(contentResolver, selectionCoordinator2);
            this.adapter = fileListAdapter;
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(fileListAdapter);
            }
        } else {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(newPermissionsRequestAdapter(new ViewOnClickListenerC11179a(viewInflate, this, flexInputCoordinator)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(C11170R.f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new FilesFragment2(new C11180b(this)));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator = this.selectionCoordinator;
        if (selectionCoordinator != null) {
            selectionCoordinator.itemSelectionListener.unregister();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        loadDownloadFolder();
    }

    public final void setRecyclerView$flexinput_release(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
