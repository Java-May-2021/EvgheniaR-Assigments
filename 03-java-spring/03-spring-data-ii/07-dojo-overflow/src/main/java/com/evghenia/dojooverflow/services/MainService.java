package com.evghenia.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evghenia.dojooverflow.models.Answer;
import com.evghenia.dojooverflow.models.Question;
import com.evghenia.dojooverflow.models.Tag;
import com.evghenia.dojooverflow.repositories.AnswerRepository;
import com.evghenia.dojooverflow.repositories.QuestionRepository;
import com.evghenia.dojooverflow.repositories.TagRepository;

@Service
public class MainService {
	@Autowired
	private QuestionRepository questRepo;
	@Autowired
	private TagRepository tagRepo;
	@Autowired
	private AnswerRepository aRepo;
	
	
	public List<Question> getAllQuestions(){
		return this.questRepo.findAll();
	}
	public Question getSingleQuestion(Long id) {
		return this.questRepo.findById(id).orElse(null);
	}
	public Question createQuestion(Question question) {
		ArrayList<Tag> questionsTags = new ArrayList<Tag>();
		String tags = question.getTags();
		
		String[] qTags = tags.split(",");
		
		for(String subject: qTags) {
			System.out.println(subject);
			Tag tag = this.tagRepo.findBySubject(subject.toLowerCase().trim());
			if(tag == null) {
				tag = new Tag(subject);
				tag.setSubject(subject);
				this.tagRepo.save(tag);
			}
			
			if(!questionsTags.contains(tag)) {
				questionsTags.add(tag);
			}
		}
		Question newQuestion = new Question(question.getQuestion(),questionsTags);
		return this.questRepo.save(newQuestion);
	
		}
	public List<Tag> getAllTags(){
		return this.tagRepo.findAll();
	}
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	public void addAnswerToQuestion(Question question, Answer answer) {
		List<Answer> selectedQuestion = question.getAnswers();
		selectedQuestion.add(answer); 
		this.aRepo.save(answer);
	}
	public List<Answer> getAllAnswers() {
		return this.aRepo.findAll();
	}
	public Answer addAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	    
}
