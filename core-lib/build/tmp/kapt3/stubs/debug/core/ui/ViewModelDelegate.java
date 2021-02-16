package core.ui;

import java.lang.System;

/**
 * Delegate class to handle ViewModel initialization in fragment/activity
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J#\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\b\u00a2\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0096\u0002\u00a2\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0088\u000e\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcore/ui/ViewModelDelegate;", "T", "Landroidx/lifecycle/ViewModel;", "Lkotlin/properties/ReadOnlyProperty;", "Lcore/ui/BaseFragment;", "scope", "Lcore/ui/ViewModelScope;", "(Lcore/ui/ViewModelScope;)V", "viewModel", "Landroidx/lifecycle/ViewModel;", "createViewModel", "fragment", "javaClass", "Ljava/lang/Class;", "(Lcore/ui/BaseFragment;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lcore/ui/BaseFragment;Lkotlin/reflect/KProperty;)Landroidx/lifecycle/ViewModel;", "requireParentActivity", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/Fragment;", "core-lib_debug"})
public final class ViewModelDelegate<T extends androidx.lifecycle.ViewModel> implements kotlin.properties.ReadOnlyProperty<core.ui.BaseFragment, T> {
    private T viewModel;
    private final core.ui.ViewModelScope scope = null;
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Override()
    public T getValue(@org.jetbrains.annotations.NotNull()
    core.ui.BaseFragment thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property) {
        return null;
    }
    
    private final T createViewModel(core.ui.BaseFragment fragment, java.lang.Class<T> javaClass) {
        return null;
    }
    
    private final androidx.fragment.app.FragmentActivity requireParentActivity(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$requireParentActivity) {
        return null;
    }
    
    public ViewModelDelegate(@org.jetbrains.annotations.NotNull()
    core.ui.ViewModelScope scope) {
        super();
    }
    
    public ViewModelDelegate() {
        super();
    }
}