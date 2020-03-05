package edu.slcc;

import java.util.Date;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseListener;
import javax.faces.event.PhaseId;

public class PhaseListenerASDV implements PhaseListener
{
    private static final String PHASE_PARAMETER = "edu.slcc.phaseListenerASDV.phase";
    private static final Logger logger = Logger.getLogger("edu.slcc.phases");
    private static String phase = null;

    public void setPhase(String newValue) {phase = newValue;}

    @Override public void beforePhase(PhaseEvent e){
        logger.info("BEFORE " + e.getPhaseId()
                + " on " + new Date().toString());
    }
    @Override public void afterPhase(PhaseEvent e){
        logger.info("AFTER " + e.getPhaseId()
                + " on " + new Date().toString());
    }
    @Override public PhaseId getPhaseId()
    {
        if (phase == null)
          {
            FacesContext context = FacesContext.getCurrentInstance();
            phase = (String) context.getExternalContext().getInitParameter(
                    PHASE_PARAMETER);
          }
        PhaseId phaseId = PhaseId.ANY_PHASE;
        if (phase != null)
          {
            if ("RESTORE_VIEW".equals(phase))               phaseId = PhaseId.RESTORE_VIEW;
            else if ("APPLY_REQUEST_VALUES".equals(phase))  phaseId = PhaseId.APPLY_REQUEST_VALUES;
            else if ("PROCESS_VALIDATIONS".equals(phase))   phaseId = PhaseId.PROCESS_VALIDATIONS;
            else if ("UPDATE_MODEL_VALUES".equals(phase))   phaseId = PhaseId.UPDATE_MODEL_VALUES;      
            else if ("INVOKE_APPLICATION".equals(phase))    phaseId = PhaseId.INVOKE_APPLICATION;      
            else if ("RENDER_RESPONSE".equals(phase))       phaseId = PhaseId.RENDER_RESPONSE;    
            else if ("ANY_PHASE".equals(phase))             phaseId = PhaseId.ANY_PHASE;             
          }
        return phaseId;
    }
}
