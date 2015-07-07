package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.RoundDao;
import com.cims.model.datastruct.RoundList;
import com.cims.model.persist.Round;


@Service("RoundProcess")
public class RoundProcess {

	private final transient Logger log = Logger.getLogger(RoundProcess.class);
	@Autowired
	private RoundDao roundDao;

	//增
	public boolean saveRound(Round round) {
		boolean done = true;
		try {
			roundDao.create(round);
		} catch (Exception e) {
			done = false;
			log.error(e.getMessage());
		}
		return done;
	}
	//删
	public boolean detete(String id){
		boolean done=false;
		try{
			roundDao.delete(Integer.valueOf(id));
			done=true;
		}catch(Exception e){
			log.error(e.getMessage());
			done=false;
		}
		return done;
	}	
	//查
	public Round retrieve(Integer id){
		try{
			return roundDao.retrieveById(id);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return null;
	}
	public boolean retrieve(String  roundName){
		boolean accept=false;
		try{
			Round filter=new Round();
			filter.setRoundName(roundName);
			if( roundDao.retrieve(filter)!=null){
				accept=false;
			}else{
				accept=true;
			}	
		}catch(Exception e){
			log.error(e.getMessage());
			accept=false;
		}
		return accept;
	}
	public boolean retrieveExclude(String  roundName,Integer id){
		boolean accept=false;
		try{
			Round filter=new Round();
			filter.setRoundName(roundName);
			filter.setRoundId(id);
			if( roundDao.retrieveExclude(filter)!=null){
				accept=false;
			}else{
				accept=true;
			}	
		}catch(Exception e){
			log.error(e.getMessage());
			accept=false;
		}
		return accept;
	}
	public boolean acceptChangeHasNode(Integer id){
		boolean accept=false;
		try{
			if( roundDao.childrenRecords(id)!=0){
				accept=false;
			}else{
				accept=true;
			}	
		}catch(Exception e){
			log.error(e.getMessage());
			accept=false;
		}
		return accept;
	}
	//改
	public boolean update(Round round){
		boolean done=false;
		try{
			roundDao.update(round);
			done=true;
		}catch(Exception e){
			log.error(e.getMessage());
			done=false;
		}
		return done;
	}
	//查
	public List<Round> retrieveList(Round round){
		List<Round> roundList=new ArrayList<Round>();
		try {
			roundList = roundDao.retrieveList(round);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return roundList;
	}
	public List<Round> retrieveParentList(Round round){
		List<Round> roundList=new ArrayList<Round>();
		try {
			roundList = roundDao.retrieveParentList(round);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return roundList;
	}
	
	public RoundList retrieveRoundList(){
		RoundList root=new RoundList();
		try {
			List<Round> roundList=roundDao.retrieveList();
			for(int i=0;i<roundList.size();i++){
				Round round=roundList.get(i);
				if(round.getParent()==-1){
					//找到根节点
					root.setRound(round);
					roundList.remove(i);
					break;
				}
			}
			constructRoundTree(root, roundList);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return root;
	}
	private RoundList constructRoundTree(RoundList root,List<Round> roundList){
		for(int i=0;i<roundList.size();i++){
			Round round=roundList.get(i);
			if(round.getParent()==root.getRound().getRoundId()){
				RoundList child=new RoundList();
				child.setRound(round);
				root.getChildren().add(child);
			}
		}
		for(int i=0;i<root.getChildren().size();i++){
			constructRoundTree(root.getChildren().get(i), roundList);
		}
		return root;
	}
	public boolean prepareDelete(Integer id) {
		boolean accept=false;
		try{
			Integer records=roundDao.childrenRecords(id);
			if(records>0){
				accept=false;
			}else{
				accept=true;
			}
		}catch(Exception e){
			log.error(e.getMessage());
			accept=false;
		}
		return accept;
	}
}
