/**
 * generated by Xtext
 */
package org.etri.slice.tools.adl.domainmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.etri.slice.tools.adl.domainmodel.Command;
import org.etri.slice.tools.adl.domainmodel.CommandSet;
import org.etri.slice.tools.adl.domainmodel.DomainmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.etri.slice.tools.adl.domainmodel.impl.CommandSetImpl#getControl <em>Control</em>}</li>
 *   <li>{@link org.etri.slice.tools.adl.domainmodel.impl.CommandSetImpl#getCommands <em>Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandSetImpl extends MinimalEObjectImpl.Container implements CommandSet
{
  /**
   * The cached value of the '{@link #getControl() <em>Control</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControl()
   * @generated
   * @ordered
   */
  protected JvmTypeReference control;

  /**
   * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommands()
   * @generated
   * @ordered
   */
  protected EList<Command> commands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommandSetImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DomainmodelPackage.Literals.COMMAND_SET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getControl()
  {
    return control;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetControl(JvmTypeReference newControl, NotificationChain msgs)
  {
    JvmTypeReference oldControl = control;
    control = newControl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomainmodelPackage.COMMAND_SET__CONTROL, oldControl, newControl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setControl(JvmTypeReference newControl)
  {
    if (newControl != control)
    {
      NotificationChain msgs = null;
      if (control != null)
        msgs = ((InternalEObject)control).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomainmodelPackage.COMMAND_SET__CONTROL, null, msgs);
      if (newControl != null)
        msgs = ((InternalEObject)newControl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomainmodelPackage.COMMAND_SET__CONTROL, null, msgs);
      msgs = basicSetControl(newControl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.COMMAND_SET__CONTROL, newControl, newControl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Command> getCommands()
  {
    if (commands == null)
    {
      commands = new EObjectContainmentEList<Command>(Command.class, this, DomainmodelPackage.COMMAND_SET__COMMANDS);
    }
    return commands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DomainmodelPackage.COMMAND_SET__CONTROL:
        return basicSetControl(null, msgs);
      case DomainmodelPackage.COMMAND_SET__COMMANDS:
        return ((InternalEList<?>)getCommands()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DomainmodelPackage.COMMAND_SET__CONTROL:
        return getControl();
      case DomainmodelPackage.COMMAND_SET__COMMANDS:
        return getCommands();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DomainmodelPackage.COMMAND_SET__CONTROL:
        setControl((JvmTypeReference)newValue);
        return;
      case DomainmodelPackage.COMMAND_SET__COMMANDS:
        getCommands().clear();
        getCommands().addAll((Collection<? extends Command>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DomainmodelPackage.COMMAND_SET__CONTROL:
        setControl((JvmTypeReference)null);
        return;
      case DomainmodelPackage.COMMAND_SET__COMMANDS:
        getCommands().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DomainmodelPackage.COMMAND_SET__CONTROL:
        return control != null;
      case DomainmodelPackage.COMMAND_SET__COMMANDS:
        return commands != null && !commands.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CommandSetImpl
